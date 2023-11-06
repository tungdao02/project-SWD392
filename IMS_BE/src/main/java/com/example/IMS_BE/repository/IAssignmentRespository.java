package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssignmentRespository extends JpaRepository<Assignment,Long> {
}
