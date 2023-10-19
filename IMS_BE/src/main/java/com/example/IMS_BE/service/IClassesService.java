package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Classes;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface IClassesService {
    public List<Classes> GetAllClasses();
    public List<Classes> GetClassesById(long id);
    public void AddClass(Classes classes);
    public void DeleteClass(Classes classes);
    public void UpdateClass(Classes classes);
    public Classes GetClassById(long id);
    public void CancelClass(long id);
}
