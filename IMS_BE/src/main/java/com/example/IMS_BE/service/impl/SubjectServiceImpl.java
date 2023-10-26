package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.repository.SettingRepository;
import com.example.IMS_BE.repository.SubjectRepository;
import com.example.IMS_BE.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public void addSubject(Subject subject) {

    }

    @Override
    public void saveSubject(Subject subject) {

    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public Optional<Subject> findSubjectById(Long id) {
        return subjectRepository.findById(id);
    }


    @Override
    public Page<Subject> findByNameContaining(String keyword, Pageable pageable) {
        return subjectRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public Page<Subject> findByManager_UsernameContaining(String keyword, Pageable pageable) {
        return subjectRepository.findByManager_UsernameContaining(keyword, pageable);
    }
}
