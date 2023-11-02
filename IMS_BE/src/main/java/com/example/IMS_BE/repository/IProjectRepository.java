package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IProjectRepository extends JpaRepository<Project,Long> {
List<Project> findAllByClasses(Classes classes);
}
