package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentProjectRepository extends JpaRepository<StudentProject, Long> {
}
