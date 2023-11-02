package com.example.IMS_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.IMS_BE.entity.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>{
    
}
