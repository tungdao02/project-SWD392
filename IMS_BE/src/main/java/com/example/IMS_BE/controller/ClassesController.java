package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.impl.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachermanager")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/")
    public String index(@RequestParam(value = "id", required = false, defaultValue = "") Long id, Model model) {
        Classes formModel = new Classes();

        if (id != null) {
            formModel = classesService.getClassById(id);
        }

        model.addAttribute("classesForm", formModel);
        model.addAttribute("lstClasses", classesService.getAllClasses());

        return "TeacherManager";
    }


    @RequestMapping("/save")
    @PostMapping
    public String save(@ModelAttribute("classesForm") Classes classesInfo, Model model) {
        classesService.saveClass(classesInfo);
        return "redirect:/classes/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = false, defaultValue = "") Long id, Model model) {
        if (id != null) {
            classesService.deleteClass(id);
        }

        return "redirect:/classes/";
    }
}
