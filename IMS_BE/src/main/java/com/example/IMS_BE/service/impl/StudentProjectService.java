package com.example.IMS_BE.service.impl;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.IProjectRepository;
import com.example.IMS_BE.repository.IStudentProjectRepository;
import com.example.IMS_BE.repository.UserRepository;
import com.example.IMS_BE.service.IStudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class StudentProjectService implements IStudentProjectService {
    private final IStudentProjectRepository studentProjectRepository;
    private final IProjectRepository projectRepository; // Thêm trường projectRepository
    private final UserRepository userRepository;

    @Autowired
    public StudentProjectService(IStudentProjectRepository studentProjectRepository, IProjectRepository projectRepository, UserRepository userRepository) {
        this.studentProjectRepository = studentProjectRepository;
        this.projectRepository = projectRepository; // Inject projectRepository
        this.userRepository = userRepository;
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

    public void moveStudentBetweenProjects(Long currentProjectId, Long newProjectId, Long studentId) {
        // Tìm StudentProject dựa trên project_id hiện tại và student_id
        StudentProject studentProject = studentProjectRepository.getStudentProjectById(currentProjectId);

        if (studentProject != null) {
            // Xóa StudentProject khỏi dự án hiện tại
            studentProjectRepository.deleteById(currentProjectId);

            // Tạo một mới StudentProject với newProjectId và user
            StudentProject newStudentProject = new StudentProject();

            // Lấy thông tin sinh viên từ repository (giả sử có UserRepository)
            User user = userRepository.findById(studentId).orElse(null);
            newStudentProject.setUser(user);

            // Lấy dự án từ repository
            Project newProject = projectRepository.findById(newProjectId).orElse(null);
            newStudentProject.setProject(newProject);

            // Lưu mới StudentProject vào dự án mới
            studentProjectRepository.save(newStudentProject);
        } else {
            // Xử lý trường hợp không tìm thấy studentProject
        }
    }




    }