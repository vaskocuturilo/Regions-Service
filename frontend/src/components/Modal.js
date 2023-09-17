import React from "react";
import styles from "./Modal.module.css";
import { RiCloseLine } from "react-icons/ri";

const Modal = (e) => {
  return (
    <>
      <div className={styles.darkBG} />
      <div className={styles.centered}>
        <div className={styles.modal}>
          <div className={styles.modalHeader}>
            <h5 className={styles.heading}>Dialog</h5>
          </div>
          <button className={styles.closeBtn}>
            <RiCloseLine style={{ marginBottom: "-3px" }} />
          </button>
          <div className={styles.modalContent}>
           This is region service application. You can use this application free only two minutes at all.
           <br/>
           <br/>
           If you want to use API, you need register a new account for generation a new API KEY.
          </div>
          <div className={styles.modalActions}>
            <div className={styles.actionsContainer}>
              <button className={styles.deleteBtn} data-cy="sometag">
                I got it.
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Modal;