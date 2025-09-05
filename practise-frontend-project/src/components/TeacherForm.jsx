import React, { useState } from "react";
import axios from "axios";
import config from "../config";

const API_URL = `${config.url}/api/teacher`;

const TeacherForm = ({ refresh }) => {
  const [teacher, setTeacher] = useState({ id: "", name: "", gender: "", contact: "", subject: "" });

  const handleChange = (e) => {
    setTeacher({ ...teacher, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post(`${API_URL}/add`, [teacher]);
      alert("Teacher added successfully!");
      refresh();
      setTeacher({ id: "", name: "", gender: "", contact: "", subject: "" });
    } catch (error) {
      console.error("Error adding teacher:", error);
      alert("Error adding teacher. Please try again.");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="form">
      <input name="id" placeholder="ID" value={teacher.id} onChange={handleChange} required />
      <input name="name" placeholder="Name" value={teacher.name} onChange={handleChange} required />
      <input name="gender" placeholder="Gender" value={teacher.gender} onChange={handleChange} required />
      <input name="contact" placeholder="Contact" value={teacher.contact} onChange={handleChange} required />
      <input name="subject" placeholder="Subject" value={teacher.subject} onChange={handleChange} required />
      <button type="submit">Add Teacher</button>
    </form>
  );
};

export default TeacherForm;
