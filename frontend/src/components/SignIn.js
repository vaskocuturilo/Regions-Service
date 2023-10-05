import React, { useState } from "react";
import styles from "./Modal.module.css";
import { RiCloseLine } from "react-icons/ri";

const SignIn = ({ setIsOpen1 }) => {

  const [loginError, setLoginError] = useState('');
  const [passwordError, setPasswordError] = useState('');


  const onSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    fetch("http://localhost:8080/login", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: formData.get('login'),
        password: formData.get('password'),
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        if(data.fieldErrors) {
          data.fieldErrors.forEach(fieldError => {
            if(fieldError.field === 'login'){
              setLoginError(fieldError.message);
            }

            if(fieldError.field === 'password'){
              setPasswordError(fieldError.message);
            }
          });
        } else {
          alert("Success !!");
        }
      })
      .catch((err) => err);
  }
  
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
          <label-modal>Login:</label-modal>
          <input
          type="text"
          placeholder="Enter login"
          data-cy="loginInput"
          className="form-control input-modal"
        />{loginError ? <span style={{ color: 'red', fontSize: '12px'}}>{loginError}</span> : ''}
        <label-modal>Password:</label-modal>
         <input
          type="password"
          placeholder="Enter password"
          maxlength="4"
          data-cy="passwordInput"
          className="form-control input-modal"
        />{ passwordError ? <span style={{ color: 'red', fontSize: '12px'}}>{passwordError}</span> : ''}
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