import styles from "./Modal.module.css";

const SignIn = ({ signIsOpen }) => {
  return (
      <div>
      <form>
      <div className={styles.title}>Welcome</div>
      <div className={styles.subtitle}>Let's login!</div>
      <div className="input-container ic1">
        <input id="login" className={styles.input} type="text" placeholder="Login" data-cy="loginInput"/>
        <div className="cut"></div>
        <label for="login" className="placeholder">Login:</label>
      </div>
      <div className="input-container ic2">
        <input id="password" className={styles.input} type="text" placeholder="Password" data-cy="passwordInput"/>
        <div className="cut"></div>
        <label for="password" className="placeholder">Password:</label>
      </div>
      <button type="text" className={styles.submit} data-cy="loginButton" onClick={() => alert('Soon')}>Login</button>
      &nbsp;&nbsp;
     <button type="text" className={styles.submit} data-cy="cancelButton">Cancel</button>
      </form>
    </div>
  );
};

export default SignIn;