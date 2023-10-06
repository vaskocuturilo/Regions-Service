import React, { useState } from "react";

const SignIn = ({ signIsOpen }) => {
  const [showForm, setShowForm] = useState(false);
 
  return (
    <>
      <div>
      <form>
      <div className="title">Welcome</div>
      <div className="subtitle">Let's login!</div>
      <div className="input-container ic1">
        <input id="login" className="input" type="text" placeholder="Login" data-cy="loginInput"/>
        <div className="cut"></div>
        <label for="login" className="placeholder">Login:</label>
      </div>
      <div className="input-container ic2">
        <input id="password" className="input" type="text" placeholder="Password" data-cy="passwordInput"/>
        <div className="cut"></div>
        <label for="password" className="placeholder">Password:</label>
      </div>
      <button type="text" className="submit" data-cy="loginButton">Login</button>
      &nbsp;&nbsp;
     <button type="text" className="submit" data-cy="cancelButton">Cancel</button>
      </form>
      {showForm && (
        <form>
        </form>
      )}
    </div>
    </>
  );
};

export default SignIn;