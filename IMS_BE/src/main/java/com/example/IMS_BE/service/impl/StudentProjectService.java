package com.example.IMS_BE.service.impl;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.IStudentProjectRepository;
import com.example.IMS_BE.service.IStudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentProjectService implements IStudentProjectService {
    private final IStudentProjectRepository studentProjectRepository;

    @Autowired
    public StudentProjectService(IStudentProjectRepository studentProjectRepository) {
        this.studentProjectRepository = studentProjectRepository;
    }

    public List<StudentProject> getAllStudentProjects() {
        return studentProjectRepository.findAll();
    }

    public StudentProject getStudentProjectById(Long id) {
        return studentProjectRepository.findById(id).orElse(null);
    }

    public StudentProject saveStudentProject(StudentProject studentProject) {
        return studentProjectRepository.save(studentProject);
    }

    public void deleteStudentProject(Long id) {
        studentProjectRepository.deleteById(id);
    }

    @Override
    public List<StudentProject> getAllByStudent(User user) {
        return studentProjectRepository.findByUser(user);
    }
}