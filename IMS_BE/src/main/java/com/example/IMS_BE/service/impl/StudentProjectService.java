package com.example.IMS_BE.service.impl;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.repository.IStudentProjectRepository;
import com.example.IMS_BE.service.IStudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class StudentProjectService implements IStudentProjectService {
    private final IStudentProjectRepository studentProjectRepository;

    @Autowired
    public StudentProjectService(IStudentProjectRepository studentProjectRepository) {
        this.studentProjectRepository = studentProjectRepository;
    }

    public List<StudentProject> getAllStudentProjects() {
        List<StudentProject> studentProjects = studentProjectRepository.findAll();
        Collections.sort(studentProjects, Comparator.comparing(sp -> sp.getProject().getId()));
        return studentProjects;
    }


    public StudentProject getStudentProjectById(Long id) {
        return studentProjectRepository.findById(id).orElse(null);
    }
    public List<StudentProject> getStudentsByProjectId(Long projectId) {
        return studentProjectRepository.findByProjectId(projectId);
    }


    public StudentProject saveStudentProject(StudentProject studentProject) {
        return studentProjectRepository.save(studentProject);
    }

    public void deleteStudentProject(Long id) {
        studentProjectRepository.deleteById(id);
    }

    @Override
    public List<StudentProject> searchAll() {
        return studentProjectRepository.searchAllProject();
    }

    public void deleteStudentByProjectAndUser(Long projectId, Long userId) {
        studentProjectRepository.deleteByProjectIdAndUserId(projectId, userId);
    }


    public void removeStudentFromProject(Long projectId, Long studentId) {
        // Tìm StudentProject dựa trên project_id và student_id
        StudentProject studentProject = studentProjectRepository.findByProjectIdAndUserId(projectId, studentId);

        if (studentProject != null) {
            // Xóa StudentProject
            studentProjectRepository.delete(studentProject);
        }
    }





}