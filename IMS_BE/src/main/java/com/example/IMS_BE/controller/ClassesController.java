package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.service.IClassesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService _classesService;
    @GetMapping("/")
    public String GetClassesList(Model model){
        List<Classes> list = _classesService.GetAllClasses();
        model.addAttribute("list",list);

        return "ClassesList";
    } 
}
