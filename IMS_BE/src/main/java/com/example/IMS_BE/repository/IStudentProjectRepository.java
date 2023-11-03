package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentProjectRepository extends JpaRepository<StudentProject, Long> {
    List<StudentProject> findByProjectId(Long projectId);

    void deleteByProjectIdAndUserId(Long projectId, Long userId);

    StudentProject findByProjectIdAndUserId(Long projectId, Long studentId);

    StudentProject getStudentProjectById(Long currentProjectId);
}
