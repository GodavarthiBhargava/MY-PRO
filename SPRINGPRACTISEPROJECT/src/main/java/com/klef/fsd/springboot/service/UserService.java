package com.klef.fsd.springboot.service;

import java.util.List;
import com.klef.fsd.springboot.model.User;

public interface UserService 
{
   // Add a new user
   public String addUser(User u);

   // Update an existing user
   public String updateUser(User u);

   // Delete user by ID
   public String deleteUser(int uid);

   // View all users
   public List<User> viewAllUsers();

   // View a specific user by ID
   public User viewUserById(int uid);

   // Alternative delete method (could be used for soft deletes or different logic)
   public String removeUser(int uid);
}
