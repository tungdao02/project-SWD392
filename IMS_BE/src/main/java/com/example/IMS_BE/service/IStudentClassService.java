package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.StudentClass;
import com.example.IMS_BE.entity.User;

import java.util.List;

public interface IStudentClassService {
    public List<StudentClass> getClassesByUser(User user);
}
