import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import UserPage from "./pages/UserPage";
import TeacherPage from "./pages/TeacherPage";

function App() {
  return (
    <Router>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/users" element={<UserPage />} />
          <Route path="/teachers" element={<TeacherPage />} />
          <Route path="/" element={<h2>Welcome to Spring Boot + React App</h2>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
