package com.example.IMS_BE.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.IMS_BE.entity.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
    Page<Subject> findByNameContaining(String keyword, Pageable pageable);
    Page<Subject> findByManager_UsernameContaining(String keyword, Pageable pageable);
}

