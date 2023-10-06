import React, { useState } from "react";

const SignUp = ({ signInSignUp }) => {

  const [showForm, setShowForm] = useState(false);
 
 return (
   <>
     <div>
     <form>
     <div className="title">Welcome</div>
     <div className="subtitle">Let's create your account!</div>
     <div className="input-container ic1">
       <input id="firstname" className="input" type="text" placeholder="First Name" data-cy="firstNameInput"/>
       <div className="cut"></div>
       <label for="firstname" className="placeholder">First name</label>
     </div>
     <div className="input-container ic2">
       <input id="lastname" className="input" type="text" placeholder="Last Name" data-cy="lastNameInput"/>
       <div className="cut"></div>
       <label for="lastname" className="placeholder">Last name</label>
     </div>
     <div className="input-container ic2">
       <input id="email" className="input" type="text" placeholder="Login" data-cy="loginInput"/>
       <div className="cut cut-short"></div>
       <label for="email" className="placeholder">Login</label>
     </div>
     <div className="input-container ic2">
       <input id="email" className="input" type="text" placeholder="Password" data-cy="passwordInput"/>
       <div className="cut cut-short"></div>
       <label for="email" className="placeholder">Password</label>
     </div>
     <button type="text" className="submit" data-cy="createAccountButton">Create Account</button>
     &nbsp;&nbsp;
     <button type="text" className="submit" data-cy="cancelButton">Cancel</button>
     </form>
     {showForm && (
       <form></form>
     )}
   </div>
   </>
  );
};

export default SignUp;