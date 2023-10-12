package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Classes;

import java.util.List;

public interface IClassesService {

        List<Classes> getAllClasses();
       Classes insertnewClass(Classes newClass);

        Classes getClassById(Integer id);
        void deleteById(Integer id);

}
