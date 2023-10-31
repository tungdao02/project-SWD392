package com.example.IMS_BE.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.repository.ISubjectRepository;

@Service
public class SubjectService {
    @Autowired
    private  ISubjectRepository iSubjectRepository;

    public List<Subject> getAllSubject(){
        return iSubjectRepository.findAll();
    }
}
