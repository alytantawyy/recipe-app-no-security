package com.zosh.recipesharingyoutube.service;

import java.util.List;

import com.zosh.recipesharingyoutube.model.User;

public interface UserService {
    
    public User findUserById(Long Id) throws Exception;

    public User createUser(User user) throws Exception;

    public List<User> getAllUsers() throws Exception;

    public void deleteUser(Long id) throws Exception;

    public User updateUser(User user, Long Id) throws Exception;
    
}