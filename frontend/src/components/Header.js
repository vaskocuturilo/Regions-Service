import React from "react";
import { Nav, Navbar, NavDropdown } from "react-bootstrap";
import { ReactComponent as Logo } from "../img/logo.svg";
import "bootstrap/dist/css/bootstrap.min.css";


function Header() {
    return (
        <Navbar collapseOnSelect expand={false} bg="dark" variant="dark" data-cy="nav-bar-bottom">
        <Navbar.Brand href="#home">
          <Logo
            alt=""
            width="30"
            height="30"
            className="d-inline-block align-top"
          />
          Regions Service
        </Navbar.Brand>
        <Navbar.Brand className="ml-auto" onClick={()=>{ alert('SignIn'); }} style={{cursor: 'grab'}}>Sign In</Navbar.Brand>
        <Navbar.Brand className="ml-auto" onClick={()=>{ alert('SignUp'); }} style={{cursor: 'grab'}}>Sign Up</Navbar.Brand>
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