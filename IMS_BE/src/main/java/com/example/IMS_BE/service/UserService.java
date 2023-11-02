package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();
    boolean isAdmin(String username);

    boolean checkLogin(String username, String password);

    public User getUserByUsername(String username);

}

