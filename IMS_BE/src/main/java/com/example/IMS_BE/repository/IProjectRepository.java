package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Project;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProjectRepository extends JpaRepository<Project, Long> {
    public java.util.List<Project> getProjectByClassId(Long id);
}
