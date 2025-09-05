package com.klef.fsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.springboot.model.User;
import com.klef.fsd.springboot.service.UserService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home() {
        return "Spring Boot REST JPA - User API";
    }

    @GetMapping("/viewall")
    public List<User> viewAllUsers() {
        return service.viewAllUsers();
    }

    @PostMapping("/add")
    public String addUsers(@RequestBody List<User> users) {
        for (User u : users) {
            service.addUser(u);
        }
        return "Users added successfully";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User u) {
        return service.updateUser(u);
    }

    @DeleteMapping("/delete/{uid}")
    public String deleteUser(@PathVariable int uid) {
        return service.deleteUser(uid);
    }

    @GetMapping("/display")
    public String displayUserById(@RequestParam int uid) {
        User u = service.viewUserById(uid);

        if (u != null) {
            return u.toString();
        } else {
            return "User ID Not Found";
        }
    }

    @GetMapping("/view/{uid}")
    public String viewUserById(@PathVariable int uid) {
        User u = service.viewUserById(uid);

        if (u != null) {
            return u.toString();
        } else {
            return "User ID Not Found";
        }
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam int uid) {
        return service.removeUser(uid);
    }
}
