package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.repository.ISubjectRepository;
import com.example.IMS_BE.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    ISubjectRepository ISubjectRepository;
    @Override
    public List<Subject> getAllSubject() {
        return ISubjectRepository.findAll();
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
        ISubjectRepository.deleteById(id);
    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public Optional<Subject> findSubjectById(Long id) {
        return ISubjectRepository.findById(id);
    }


    @Override
    public Page<Subject> findByNameContaining(String keyword, Pageable pageable) {
        return ISubjectRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public Page<Subject> findByManager_UsernameContaining(String keyword, Pageable pageable) {
        return ISubjectRepository.findByManager_UsernameContaining(keyword, pageable);
    }
}
