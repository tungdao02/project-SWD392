package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.repository.SettingRepository;
import com.example.IMS_BE.repository.SubjectRepository;
import com.example.IMS_BE.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public void updateSubject(Subject subject) {

    }
}
