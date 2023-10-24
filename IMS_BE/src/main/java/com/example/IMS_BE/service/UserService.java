package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {



    boolean isAdmin(String username);

    boolean checkLogin(String username, String password);

    public User getUserByUsername(String username);

    Optional<User> findById(int id);
    List<User> findUserList();
}

