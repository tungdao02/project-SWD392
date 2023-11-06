package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.User;


import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;
@Service
public interface UserService {
    public User getUserByEmail(String username);

    List<User> getAllUsers();

    boolean isAdmin(String username);

    boolean checkLogin(String username, String password);

    public User getUserByUsername(String username);

    public User registerUser(String username, String email, String phone, String password);

}

