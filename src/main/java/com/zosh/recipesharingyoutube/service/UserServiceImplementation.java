package com.zosh.recipesharingyoutube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.recipesharingyoutube.model.User;
import com.zosh.recipesharingyoutube.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long Id) throws Exception {
        Optional<User> opt = userRepository.findById(Id);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new Exception("user not found with id " + Id);
    }

    @Override
    public User createUser(User user) throws Exception {
        
        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist!=null){
            throw new Exception ("user exists with this email: " + user.getEmail());
        }

        User createdUser = new User();
        createdUser.setPassword(user.getPassword());
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());

        return userRepository.save(createdUser);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        
        List<User> users = userRepository.findAll();

        return users;

    }

    @Override
    public void deleteUser(Long id) throws Exception {

        findUserById(id);

        userRepository.deleteUserById(id);
    }

    @Override
    public User updateUser(User user, Long Id) throws Exception {
        
        User oldUser = findUserById(Id);

        if(user.getEmail()!=null){
            oldUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            oldUser.setPassword(user.getPassword());
        }
        if(user.getFullName()!=null){
            oldUser.setFullName(user.getFullName());
        }

        return userRepository.save(oldUser);
    }
    
}