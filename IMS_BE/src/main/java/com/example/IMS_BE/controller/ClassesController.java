package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Setting;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.SettingService;
import com.example.IMS_BE.service.UserService;

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
    @Autowired
    private SettingService _settingService;
    @Autowired
    private UserService _userService;

    @GetMapping("/")
    public String GetClassesList(Model model) {
        List<Classes> list = _classesService.GetAllClasses();
        model.addAttribute("list", list);
        return "ClassesList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Setting> setting = _settingService.findAllByType("semester");

        model.addAttribute("newClass", new Classes());
        return "CreateClass";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute Classes classes) {
        _classesService.AddClass(classes);
        return "redirect:/classes/";
    }

    @GetMapping("/edit/{id}")
    public String editClass(@PathVariable Long id, Model model) {
        // Lấy thông tin lớp học dựa trên ID và gửi đến view
        Classes classToEdit = _classesService.getClassById(id);
        model.addAttribute("classToEdit", classToEdit);
        return "edit-class"; // Trả về view để chỉnh sửa
    }

    @PostMapping("/updateGeneral")
    public String updateGeneral(@ModelAttribute Classes classToEdit) {
        _classesService.updateGeneral(classToEdit);
        return "redirect:/class/edit/" + classToEdit.getId();
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Classes classToEdit) {
        // Xử lý cập nhật thông tin học sinh
        _classesService.updateStudent(classToEdit);
        return "redirect:/class/edit/" + classToEdit.getId();
    }

    @PostMapping("/updateMilestone")
    public String updateMilestone(@ModelAttribute Classes classToEdit) {
        // Xử lý cập nhật thông tin Milestone
        _classesService.updateMilestone(classToEdit);
        return "redirect:/class/edit/" + classToEdit.getId();
    }

    @PostMapping("/updateSetting")
    public String updateSetting(@ModelAttribute Classes classToEdit) {
        // Xử lý cập nhật thông tin Setting
        _classesService.updateSetting(classToEdit);
        return "redirect:/class/edit/" + classToEdit.getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        _classesService.DeleteClass(id);
        return "redirect:/classes/";
    }
}
