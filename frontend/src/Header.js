import React, { useState } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
} from "reactstrap";
import { Link } from "react-router-dom";
// import { useNavigate } from "react-router-dom";
import { useAuth } from "./hooks/useAuth";

function Header(args) {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  // const navigate = useNavigate();
  const { user, logout } = useAuth();

  return (
    <div>
      <Navbar color="dark" dark expand="md">
        <NavbarBrand href="/" className="me-5">
          STUCOUREG
        </NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem className="ms-auto">
              <Link to="/courses" style={{ textDecoration: "none" }}>
                <NavLink>Enroll</NavLink>
              </Link>
            </NavItem>
            <NavItem className="ms-auto">
              <Link to="/reg-courses" style={{ textDecoration: "none" }}>
                <NavLink>My Courses</NavLink>
              </Link>
            </NavItem>
            {!!user && (
              <NavItem className="ml-auto">
                <Link
                  to="/"
                  style={{ textDecoration: "none" }}
                  onClick={logout}
                >
                  <NavLink>Log Out</NavLink>
                </Link>
              </NavItem>
            )}
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
}

export default Header;
