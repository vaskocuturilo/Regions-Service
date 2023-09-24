import React from "react";
import styles from "./Modal.module.css";
import { RiCloseLine } from "react-icons/ri";

const SignUp = ({ setIsOpen2 }) => {
  return (
    <>
      <div className={styles.darkBG} onClick={() => setIsOpen2(false)} />
      <div className={styles.centered}>
        <div className={styles.modal}>
          <div className={styles.modalHeader}>
            <h5 className={styles.heading}>Dialog</h5>
          </div>
          <button className={styles.closeBtn} onClick={() => setIsOpen2(false)}>
            <RiCloseLine style={{ marginBottom: "-3px" }} />
          </button>
          <div className={styles.modalContent}>
          Are you sure you want to Sign Up ?
          </div>
          <div className={styles.modalActions}>
          <input
          type="text"
          placeholder="EMAIL"
          maxlength="100"
          class="login__input login__input--user"
          data-cy="emailInput"
        />
         <input
          type="text"
          placeholder="NAME"
          maxlength="25"
          class="login__input login__input--pin"
          data-cy="nameInput"
        />
         <input
          type="password"
          placeholder="PIN"
          maxlength="4"
          class="login__input login__input--pin"
          data-cy="pinInput"
        />
            <div className={styles.actionsContainer}>
              <button className={styles.deleteBtn} onClick={() => setIsOpen2(false)} data-cy="registerButton">
                Sign Up
              </button>
              <button
                className={styles.cancelBtn}
                onClick={() => setIsOpen2(false)} data-cy="cancelButton">
                Cancel
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SignUp;