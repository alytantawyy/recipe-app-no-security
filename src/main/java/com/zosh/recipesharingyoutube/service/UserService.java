package com.zosh.recipesharingyoutube.service;

import com.zosh.recipesharingyoutube.model.User;

public interface UserService {
    
    public User findUserById(Long userId) throws Exception;

    
}