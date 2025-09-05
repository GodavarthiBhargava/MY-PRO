import React, { useEffect, useState } from "react";
import axios from "axios";
import UserForm from "../components/UserForm";
import config from "../config";
import "./UserPage.css";

const API_URL = `${config.url}/api/user`;

const UserPage = () => {
  const [users, setUsers] = useState([]);

  const fetchUsers = async () => {
    try {
      const res = await axios.get(`${API_URL}/viewall`);
      setUsers(res.data);
    } catch (error) {
      console.error("Error fetching users:", error);
      alert("Error fetching users. Please check if backend is running.");
    }
  };

  const deleteUser = async (id) => {
    try {
      await axios.delete(`${API_URL}/delete/${id}`);
      alert("User deleted successfully!");
      fetchUsers();
    } catch (error) {
      console.error("Error deleting user:", error);
      alert("Error deleting user. Please try again.");
    }
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  return (
    <div className="page">
      <h2>User Management</h2>
      <UserForm refresh={fetchUsers} />
      <table>
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Gender</th><th>Contact</th><th>Location</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((u) => (
            <tr key={u.id}>
              <td>{u.id}</td>
              <td>{u.name}</td>
              <td>{u.gender}</td>
              <td>{u.contact}</td>
              <td>{u.location}</td>
              <td>
                <button onClick={() => deleteUser(u.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserPage;
