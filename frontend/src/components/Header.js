import React, { useState } from "react";
import { Nav, Navbar, NavDropdown } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

import SignIn from "./SignIn";

import SignUp from "./SignUp";

import styles from "./Modal.module.css";

function Header() {
  const [isOpen1, signIsOpen] = useState(false);
  const [isOpen2, signInSignUp] = useState(false);
    return (
        <Navbar collapseOnSelect expand={false} bg="dark" variant="dark" data-cy="nav-bar-bottom">
        <Navbar.Brand href="#home">
          <p>Regions Service</p>
        </Navbar.Brand>
        <button className={styles.primaryBtn} onClick={() => {signInSignUp(false); signIsOpen(true)}} data-cy="signIn">
        Sign In
      </button>
      {isOpen1 && <SignIn signIsOpen={signIsOpen} />}
      <button className={styles.primaryBtn} onClick={() => {signIsOpen(false); signInSignUp(true)}} data-cy="signUp">
        Sign Up
      </button>
      {isOpen2 && <SignUp signInSignUp={signInSignUp} />}

      <Navbar.Toggle aria-controls="responsive-navbar-nav" data-cy="nav-bar-button"/>
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="#features">News</Nav.Link>
            <Nav.Link href="#pricing">API</Nav.Link>
            <NavDropdown title="More details" id="collasible-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Donates</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
              Donates
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Donates</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
              Donates
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Nav>
            <Nav.Link href="#deets">About us</Nav.Link>
            <Nav.Link eventKey={2} href="#memes">
              Author
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
}

export default Header;