import React, { useState } from "react";
import axios from "axios";
import config from "../config";

const API_URL = `${config.url}/api/user`;

const UserForm = ({ refresh }) => {
  const [user, setUser] = useState({ id: "", name: "", gender: "", contact: "", location: "" });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post(`${API_URL}/add`, [user]);
      alert("User added successfully!");
      refresh();
      setUser({ id: "", name: "", gender: "", contact: "", location: "" });
    } catch (error) {
      console.error("Error adding user:", error);
      alert("Error adding user. Please try again.");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="form">
      <input name="id" placeholder="ID" value={user.id} onChange={handleChange} required />
      <input name="name" placeholder="Name" value={user.name} onChange={handleChange} required />
      <input name="gender" placeholder="Gender" value={user.gender} onChange={handleChange} required />
      <input name="contact" placeholder="Contact" value={user.contact} onChange={handleChange} required />
      <input name="location" placeholder="Location" value={user.location} onChange={handleChange} required />
      <button type="submit">Add User</button>
    </form>
  );
};

export default UserForm;
