package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.UserRepository;
import com.example.IMS_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    public Optional<User> findByPhone(String phone) {
        return Optional.ofNullable(userRepository.findByPhone(phone));
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isAdmin(String username) {
        String roles = userRepository.findRolesByPhone(username);
        String roles2 = userRepository.findRolesByEmail(username);
        return (roles != null && roles.contains("admin")) || (roles2 != null && roles2.contains("admin"));
    }


    @Override
    public boolean checkLogin(String username, String password) {
        Optional<User> optionalUser = findByPhone(username);
        Optional<User> optionalUser2 = findByEmail(username);
        if ((optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) || (optionalUser2.isPresent() && optionalUser2.get().getPassword().equals(password))) {
            return true;
        }

        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
