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
import org.springframework.web.bind.annotation.RequestMapping;






@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping()
    public User createUser(@RequestBody User user) throws Exception{

        User createdUser = userService.createUser(user);

        return createdUser;
       
    }

    @GetMapping()
    public List<User> getAllUsers() throws Exception{

        List <User> users = userService.getAllUsers();

        return users;
    }


    @DeleteMapping("/{userId}")
     public String deleteUser(@PathVariable Long userId) throws Exception{

        userService.deleteUser(userId);

        return "User deleted successfully";
    }


    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Long userId) throws Exception{

        User updatedUser = userService.updateUser(user, userId);

        return updatedUser;

    }
    
}