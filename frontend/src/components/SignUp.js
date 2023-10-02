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
          <label-modal>Firstname:</label-modal>
          <input
          type="text"
          placeholder="Enter first name"
          maxlength="100"
          class="form-control inp_text"
          data-cy="firstNameInput"
        />
        <label-modal>Lastname:</label-modal>
          <input
          type="text"
          placeholder="Enter last name"
          maxlength="100"
          class="form-control inp_text"
          data-cy="lastNameInput"
        />
         <label-modal>Email:</label-modal>
         <input
          type="text"
          placeholder="Enter email"
          maxlength="25"
          class="form-control inp_text"
          data-cy="emailInput"
        />
         <label-modal>Password:</label-modal>
         <input
          type="password"
          placeholder="Enter password"
          maxlength="4"
          class="form-control inp_text"
          data-cy="passwordInput"
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