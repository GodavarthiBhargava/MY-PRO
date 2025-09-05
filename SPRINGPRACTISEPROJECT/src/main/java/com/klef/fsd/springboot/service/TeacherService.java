package com.klef.fsd.springboot.service;

import java.util.List;
import com.klef.fsd.springboot.model.Teacher;

public interface TeacherService
{
    public String addTeacher(Teacher t);
    public String updateTeacher(Teacher t);
    public String deleteTeacher(int tid);
    public List<Teacher> viewAllTeachers();
    public Teacher viewTeacherById(int tid);
    public String removeTeacher(int tid);
}
