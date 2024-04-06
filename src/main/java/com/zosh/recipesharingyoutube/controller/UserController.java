package com.zosh.recipesharingyoutube.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.recipesharingyoutube.model.User;
import com.zosh.recipesharingyoutube.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception{

        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist!=null){
            throw new Exception ("user exists with this email: " + user.getEmail());
        }

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception{

        List <User> users = userRepository.findAll();

        return users;
    }


    @DeleteMapping("/users/{userId}")
     public String deleteUser(@PathVariable Long userId) throws Exception{

        userRepository.deleteById(userId);

        return "User deleted successfully";
    }

    
}