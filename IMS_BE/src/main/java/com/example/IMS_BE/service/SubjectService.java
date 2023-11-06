package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubject();
    void addSubject(Subject subject);
    void saveSubject(Subject subject);
    void deleteSubject(Subject subject);
    void deleteSubjectById(Long id);
    void updateSubject(Subject subject);
    Optional<Subject> findSubjectById(Long id);
    Page<Subject> findByNameContaining(String keyword, Pageable pageable);
    Page<Subject> findByManager_UsernameContaining(String keyword, Pageable pageable);

}
