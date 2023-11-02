package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Project;

import java.util.List;

public interface IProjectService {
    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project saveProject(Project project);

    void deleteProject(Long id);
    public List<Project> getProjectByClassess(Classes classes);
}

