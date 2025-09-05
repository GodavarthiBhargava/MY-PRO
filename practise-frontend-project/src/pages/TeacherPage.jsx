import React, { useEffect, useState } from "react";
import axios from "axios";
import TeacherForm from "../components/TeacherForm";
import config from "../config";
import "./TeacherPage.css";

const API_URL = `${config.url}/api/teacher`;

const TeacherPage = () => {
  const [teachers, setTeachers] = useState([]);

  const fetchTeachers = async () => {
    try {
      const res = await axios.get(`${API_URL}/viewall`);
      setTeachers(res.data);
    } catch (error) {
      console.error("Error fetching teachers:", error);
      alert("Error fetching teachers. Please check if backend is running.");
    }
  };

  const deleteTeacher = async (id) => {
    try {
      await axios.delete(`${API_URL}/delete/${id}`);
      alert("Teacher deleted successfully!");
      fetchTeachers();
    } catch (error) {
      console.error("Error deleting teacher:", error);
      alert("Error deleting teacher. Please try again.");
    }
  };

  useEffect(() => {
    fetchTeachers();
  }, []);

  return (
    <div className="page">
      <h2>Teacher Management</h2>
      <TeacherForm refresh={fetchTeachers} />
      <table>
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Gender</th><th>Contact</th><th>Subject</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {teachers.map((t) => (
            <tr key={t.id}>
              <td>{t.id}</td>
              <td>{t.name}</td>
              <td>{t.gender}</td>
              <td>{t.contact}</td>
              <td>{t.subject}</td>
              <td>
                <button onClick={() => deleteTeacher(t.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TeacherPage;
