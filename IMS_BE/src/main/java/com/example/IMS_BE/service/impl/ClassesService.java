package com.example.IMS_BE.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.service.IClassesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IMS_BE.repository.IClassesRepository;
@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository _classesRepository;

    @Override
    public List<Classes> GetAllClasses() {
        return _classesRepository.findAll();
    }

    @Override
    public List<Classes> GetClassesById(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'GetClassById'");
    }

    @Override
    public void AddClass(Classes classes) {
        _classesRepository.save(classes);
    }

    @Override
    public void DeleteClass(Classes classes) {
        _classesRepository.delete(classes);
    }

    @Override
    public void UpdateClass(Classes classes) {
        _classesRepository.save(classes);
    }

    @Override
    public Classes GetClassById(long id) {
        Optional<Classes> optionalClass = _classesRepository.findById(id);
        return optionalClass.orElse(null); 
    }

    @Override
    public void CancelClass(long id) {
        Classes currentClass = GetClassById(id);
    }

}
