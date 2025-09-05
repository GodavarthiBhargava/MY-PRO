package com.klef.fsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.springboot.model.Teacher;
import com.klef.fsd.springboot.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepository repository;

    @Override
    public String addTeacher(Teacher t) {
        repository.save(t);  // Adding one teacher
        return "Teacher Added Successfully";
    }

    @Override
    public String updateTeacher(Teacher t) {
        Optional<Teacher> obj = repository.findById(t.getId());
        if (obj.isPresent()) {
            Teacher t1 = obj.get();
            t1.setName(t.getName());
            t1.setGender(t.getGender());
            t1.setContact(t.getContact());
            t1.setSubject(t.getSubject());
            repository.save(t1);
            return "Teacher Updated Successfully";
        } else {
            return "Teacher ID Not Found";
        }
    }

    @Override
    public String deleteTeacher(int tid) {
        Optional<Teacher> obj = repository.findById(tid);
        if (obj.isPresent()) {
            repository.delete(obj.get());
            return "Teacher Deleted Successfully";
        } else {
            return "Teacher ID Not Found";
        }
    }

    @Override
    public List<Teacher> viewAllTeachers() {
        return (List<Teacher>) repository.findAll();
    }

    @Override
    public Teacher viewTeacherById(int tid) {
        return repository.findById(tid).orElse(null);
    }

    @Override
    public String removeTeacher(int tid) {
        Optional<Teacher> obj = repository.findById(tid);
        if (obj.isPresent()) {
            repository.delete(obj.get());
            return "Teacher Removed Successfully";
        } else {
            return "Teacher ID Not Found";
        }
    }
}
