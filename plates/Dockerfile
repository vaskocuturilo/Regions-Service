FROM python:3.9-slim

ENV APP_HOME=/app/

WORKDIR /app

COPY plates.py requirements.txt $APP_HOME

RUN pip3 install --upgrade pip && pip install --no-cache-dir -r requirements.txt

RUN apt-get update  \
    && apt-get install ffmpeg libsm6 libxext6 tesseract-ocr -y \
    && apt-get clean

EXPOSE 8000

ENTRYPOINT ["python", "plates.py"]