package com.klef.fsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.springboot.model.User;
import com.klef.fsd.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repository;

    @Override
    public String addUser(User u) {
        repository.save(u);
        return "User Added Successfully";
    }

    @Override
    public String updateUser(User u) {
        Optional<User> object = repository.findById(u.getId());

        String msg = null;

        if (object.isPresent()) {
            User u1 = object.get();

            u1.setName(u.getName());
            u1.setGender(u.getGender());
            u1.setContact(u.getContact());
            u1.setLocation(u.getLocation());

            repository.save(u1);
            msg = "User Updated Successfully";
        } else {
            msg = "User ID Not Found to Update";
        }

        return msg;
    }

    @Override
    public String deleteUser(int uid) {
        Optional<User> object = repository.findById(uid);

        String msg = null;

        if (object.isPresent()) {
            User u = object.get();
            repository.delete(u);
            msg = "User Deleted Successfully";
        } else {
            msg = "User ID Not Found to Delete";
        }

        return msg;
    }

    @Override
    public List<User> viewAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User viewUserById(int uid) {
        return repository.findById(uid).orElse(null);
    }

    @Override
    public String removeUser(int uid) {
        Optional<User> object = repository.findById(uid);

        String msg = null;

        if (object.isPresent()) {
            User u = object.get();
            repository.delete(u);
            msg = "User Removed Successfully";
        } else {
            msg = "User ID Not Found to Delete";
        }

        return msg;
    }
}
