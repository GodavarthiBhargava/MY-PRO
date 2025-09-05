import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <h2>School Management</h2>
      <div>
        <Link to="/users">Users</Link>
        <Link to="/teachers">Teachers</Link>
      </div>
    </nav>
  );
};

export default Navbar;
