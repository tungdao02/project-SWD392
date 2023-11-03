package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
    Page<Subject> findByNameContaining(String keyword, Pageable pageable);
    Page<Subject> findByManager_UsernameContaining(String keyword, Pageable pageable);
import org.springframework.stereotype.Repository;
@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>{
}
