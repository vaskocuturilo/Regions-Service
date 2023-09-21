import React from "react";
import styles from "./Modal.module.css";
import { RiCloseLine } from "react-icons/ri";

const SignIn = ({ setIsOpen1 }) => {
  return (
    <>
      <div className={styles.darkBG} onClick={() => setIsOpen1(false)} />
      <div className={styles.centered}>
        <div className={styles.modal}>
          <div className={styles.modalHeader}>
            <h5 className={styles.heading}>Dialog</h5>
          </div>
          <button className={styles.closeBtn} onClick={() => setIsOpen1(false)}>
            <RiCloseLine style={{ marginBottom: "-3px" }} />
          </button>
          <div className={styles.modalContent}>
          Are you sure you want to Sign In ?
          </div>
          <div className={styles.modalActions}>
            <div className={styles.actionsContainer}>
              <button className={styles.deleteBtn} onClick={() => setIsOpen1(false)} data-cy="loginButton">
                Login
              </button>
              <button
                className={styles.cancelBtn}
                onClick={() => setIsOpen1(false)} data-cy="cancelButton">
                Cancel
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SignIn;