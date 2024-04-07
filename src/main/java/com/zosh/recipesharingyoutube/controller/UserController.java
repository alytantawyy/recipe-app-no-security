package com.zosh.recipesharingyoutube.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.recipesharingyoutube.model.User;
import com.zosh.recipesharingyoutube.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception{

        User createdUser = userService.createUser(user);

        return createdUser;
       
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception{

        List <User> users = userService.getAllUsers();

        return users;
    }


    @DeleteMapping("/users/{userId}")
     public String deleteUser(@PathVariable Long userId) throws Exception{

        userService.deleteUser(userId);

        return "User deleted successfully";
    }


    @PutMapping("path/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception{

        User updatedUser = userService.updateUser(user, id);

        return updatedUser;

    }
    
}