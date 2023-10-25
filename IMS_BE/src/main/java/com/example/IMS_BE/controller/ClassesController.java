package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.service.IClassesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService _classesService;

    @GetMapping("/")
    public String GetClassesList(Model model) {
        List<Classes> list = _classesService.GetAllClasses();
        model.addAttribute("list", list);
        return "ClassesList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("newClass", new Classes());
        return "CreateClass";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute Classes classes) {
        _classesService.AddClass(classes);
        return "redirect:/classes/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Classes classes = _classesService.GetClassById(id);
        model.addAttribute("classes", classes);
        return "editClass";
    }

    @PostMapping("/update/{id}")
    public String updateClass(@ModelAttribute Classes classes) {
        _classesService.UpdateClass(classes);
        return "redirect:/classes/";
    }

    @PostMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        _classesService.DeleteClass(id);
        return "redirect:/classes/";
    }
}
