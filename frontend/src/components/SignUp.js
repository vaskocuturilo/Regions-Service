import styles from "./Modal.module.css";

const SignUp = ({ signInSignUp }) => {
return (
     <div>
     <form>
     <div className={styles.title}>Welcome</div>
     <div className={styles.subtitle}>Let's create your account!</div>
     <div className="input-container ic1">
       <input id="firstname" className={styles.input} type="text" placeholder="First Name" data-cy="firstNameInput"/>
       <div className="cut"></div>
       <label for="firstname" className="placeholder">First name</label>
     </div>
     <div className="input-container ic2">
       <input id="lastname" className={styles.input} type="text" placeholder="Last Name" data-cy="lastNameInput"/>
       <div className="cut"></div>
       <label for="lastname" className="placeholder">Last name</label>
     </div>
     <div className="input-container ic2">
       <input id="email" className={styles.input} type="text" placeholder="Login" data-cy="loginInput"/>
       <div className="cut cut-short"></div>
       <label for="email" className="placeholder">Login</label>
     </div>
     <div className="input-container ic2">
       <input id="email" className={styles.input} type="text" placeholder="Password" data-cy="passwordInput"/>
       <div className="cut cut-short"></div>
       <label for="email" className="placeholder">Password</label>
     </div>
     <button type="text" className={styles.submit} data-cy="createAccountButton" onClick={() => alert('Soon')}>Create Account</button>
     &nbsp;&nbsp;
     <button type="text" className={styles.submit} data-cy="cancelButton">Cancel</button>
     </form>
   </div>
  );
};

export default SignUp;