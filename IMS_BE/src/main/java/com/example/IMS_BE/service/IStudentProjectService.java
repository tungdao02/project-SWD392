package com.example.IMS_BE.service;


import com.example.IMS_BE.entity.StudentProject;

import java.util.List;

public interface IStudentProjectService {
    List<StudentProject> getAllStudentProjects();

    StudentProject getStudentProjectById(Long id);

    StudentProject saveStudentProject(StudentProject studentProject);

    void deleteStudentProject(Long id);
}

