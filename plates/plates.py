import cv2
import logging
import numpy as np
import pytesseract
from flask import Flask, request, jsonify

status = [{'status': 'OK'}]

application = Flask(__name__)

logging.basicConfig(level=logging.INFO)
logger = application.logger


def extract_license_plate(image):
    try:
        gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

        gray = cv2.bilateralFilter(gray, 11, 17, 17)

        edged = cv2.Canny(gray, 30, 200)

        contours, _ = cv2.findContours(edged.copy(), cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
        contours = sorted(contours, key=cv2.contourArea, reverse=True)[:10]

        license_plate = None

        for contour in contours:
            approx = cv2.approxPolyDP(contour, 10, True)
            if len(approx) == 4:
                license_plate = approx
                break

        if license_plate is None:
            logger.warning("License plate not detected.")
            return None

        mask = np.zeros(gray.shape, np.uint8)
        cv2.drawContours(mask, [license_plate], 0, 255, -1)  # Draw the contour on the mask (in-place)

        x, y, w, h = cv2.boundingRect(license_plate)
        cropped = gray[y:y + h, x:x + w]

        text = pytesseract.image_to_string(cropped, config='--psm 8')
        detected_text = text.strip()

        logger.info(f"Detected License Plate: {detected_text}")
        return detected_text

    except Exception as e:
        logger.error(f"Error in extract_license_plate: {e}")
        return None


@application.route('/health', methods=['GET'])
def plate_service_status():
    return jsonify(status)


@application.route('/plates', methods=['POST'])
def plate_recognition():
    if 'file' not in request.files:
        logger.error("No image file provided in request.")
        return jsonify({"error": "No image file provided"}), 400

    file = request.files['file']

    try:
        npimg = np.frombuffer(file.read(), np.uint8)
        img = cv2.imdecode(npimg, cv2.IMREAD_COLOR)

        if img is None:
            logger.error("Invalid image format.")
            return jsonify({"error": "Invalid image format"}), 400

        plate = extract_license_plate(img)

        if plate:
            return jsonify({"plate": plate})
        else:
            return jsonify({"error": "License plate not detected"}), 404

    except Exception as e:
        logger.error(f"Error processing file: {e}")
        return jsonify({"error": "Internal server error", "details": str(e)}), 500


if __name__ == "__main__":
    application.run(debug=True, host='0.0.0.0', port=8000)
