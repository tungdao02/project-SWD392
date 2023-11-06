package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.Setting;
import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.SettingService;
import com.example.IMS_BE.service.SubjectService;
import com.example.IMS_BE.service.impl.StudentClassServiceImpl;
import com.example.IMS_BE.service.impl.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService _classesService;
    @Autowired
    private SettingService _settingService;
    @Autowired
    private UserServiceImpl _userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentClassServiceImpl studentsClassService;


    @GetMapping("/classList")
    public String GetClassesList(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String searchString) {
        int pageSize = 14;
        Page<Classes> classPage = null;
        if(searchString == null || searchString ==""){
            classPage = _classesService.findAllClasses(PageRequest.of(page - 1, pageSize));
        }else{  
            classPage = _classesService.findClassesByName(searchString,PageRequest.of(page - 1, pageSize));
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", classPage.getTotalPages());
        model.addAttribute("list", classPage.getContent());
        return "Class/ClassesList";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Setting> setting = _settingService.findAllByType("semester");
        List<User> users = _userService.findAllByRole(4);
        List<Subject> subject = subjectService.getAllSubject();
        model.addAttribute("newClass", new Classes());
        model.addAttribute("newSetting", setting);
        model.addAttribute("classSubject", subject);
        model.addAttribute("teachers", users);
        return "Class/CreateClass";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute Classes classes) {
        _classesService.AddClass(classes);
        return "redirect:classList";
    }

    @GetMapping("/addStudent/{id}")
    public String addStudent(@PathVariable int id,@RequestParam(defaultValue = "0") int classId){
        studentsClassService.addStudentIntoClass(_classesService.GetClassById(classId), _userService.findById(id).orElse(null));
        return "redirect:/classes/edit/"+classId;
    }

    @GetMapping("/removeStudent/{id}")
    public String removeStudent(@PathVariable long id,@RequestParam(defaultValue = "0") long classId){
        studentsClassService.kickStudent(classId, id);
        return "redirect:/classes/edit/"+classId;
    }

    @GetMapping("/edit/{id}")
    public String editClass(@PathVariable Long id, Model model) {
        List<Setting> setting = _settingService.findAllByType("semester");
        List<User> users = _userService.findAllByRole(4);
        List<Subject> subject = subjectService.getAllSubject();
        Classes classToEdit = _classesService.getClassById(id);
        List<Project> classProject = _classesService.findProjectByClassId(id);
        List<User> students = _classesService.findUsersByClassId(id);
        model.addAttribute("classToEdit", classToEdit);
        model.addAttribute("classSubject", subject);
        model.addAttribute("teachers", users);
        model.addAttribute("newSetting", setting);
        model.addAttribute("classProject", classProject);
        model.addAttribute("classStudent", students);
        return "Class/EditClass";
    }

    @PostMapping("/update")
    public String updateClass(@ModelAttribute Classes classToEdit) {
        _classesService.UpdateClass(classToEdit);
        return "redirect:edit/" + classToEdit.getId();
    }

    @GetMapping("/deleteCancel/{id}")
    public String deleteOrCancel(@PathVariable Long id, Model model) {
        Classes classes = _classesService.getClassById(id);
        Classes classToEdit = _classesService.getClassById(id);
        model.addAttribute("classDetails", classes);
        model.addAttribute("classModel", classToEdit);
        return "Class/DeleteOrCancelClass";
    }


    @PostMapping("/delete-cancel")
    public String deleteClass(@ModelAttribute Classes classModel) {
        if (classModel.getStatus() == 0)
            _classesService.DeleteClass(classModel.getId());
        else
            _classesService.CancelClass(classModel.getId());
        return "redirect:classList";
    }
}
