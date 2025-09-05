package com.klef.fsd.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.springboot.model.Teacher;
import com.klef.fsd.springboot.service.TeacherService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService service;

    @GetMapping("/")
    public String home() {
        return "Teacher API Running";
    }

    @GetMapping("/viewall")
    public List<Teacher> viewAllTeachers() {
        return service.viewAllTeachers();
    }

    @PostMapping("/add")
    public String addTeachers(@RequestBody List<Teacher> teachers) {
        for (Teacher t : teachers) {
            service.addTeacher(t);
        }
        return "Teachers added successfully";
    }

    @PutMapping("/update")
    public String updateTeacher(@RequestBody Teacher t) {
        return service.updateTeacher(t);
    }

    @DeleteMapping("/delete/{tid}")
    public String deleteTeacher(@PathVariable int tid) {
        return service.deleteTeacher(tid);
    }

    @GetMapping("/display")
    public String displayTeacherById(@RequestParam int tid) {
        Teacher t = service.viewTeacherById(tid);
        return (t != null) ? t.toString() : "Teacher ID Not Found";
    }

    @GetMapping("/view/{tid}")
    public String viewTeacherById(@PathVariable int tid) {
        Teacher t = service.viewTeacherById(tid);
        return (t != null) ? t.toString() : "Teacher ID Not Found";
    }

    @GetMapping("/remove")
    public String removeTeacher(@RequestParam int tid) {
        return service.removeTeacher(tid);
    }
}
