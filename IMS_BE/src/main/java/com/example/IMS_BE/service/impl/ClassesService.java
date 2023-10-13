package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    private final IClassRepository classesRepository;

    @Autowired
    public ClassesService(IClassRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    public Classes getClassById(Long id) {
        return classesRepository.findById(id).get();
    }

    public Classes saveClass(Classes classes) {
        return classesRepository.save(classes);
    }

    public void deleteClass(Long id) {
        classesRepository.deleteById(id);
    }
}