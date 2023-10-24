package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubject();
    void addSubject(Subject subject);
    void saveSubject(Subject subject);
    void deleteSubject(Subject subject);
    void updateSubject(Subject subject);

//    Optional<Subject> findSubjectName(Long id);

}
