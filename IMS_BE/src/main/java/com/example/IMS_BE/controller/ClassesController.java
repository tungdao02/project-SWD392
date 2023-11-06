package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.*;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.SettingService;
import com.example.IMS_BE.service.impl.ProjectService;
import com.example.IMS_BE.service.impl.StudentClassServiceImpl;
import com.example.IMS_BE.service.impl.StudentProjectService;
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
    private StudentProjectService studentProjectService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentClassServiceImpl studentClassService;

    @Autowired
    private IClassesService _classesService;
    @Autowired
    private SettingService _settingService;
    @Autowired
    private UserServiceImpl _userService;
    @Autowired
    private com.example.IMS_BE.service.impl.SubjectService subjectService;

    @GetMapping("/classList")
    public String GetClassesList(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 14;
        Page<Classes> classPage = _classesService.findAllClasses(PageRequest.of(page - 1, pageSize));
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

    @GetMapping("/edit/{id}")
    public String editClass(@PathVariable Long id, Model model) {
        Project formModel = new Project();

        List<Setting> setting = _settingService.findAllByType("semester");
        List<User> users = _userService.findAllByRole(4);
        List<Subject> subject = subjectService.getAllSubject();
        Classes classToEdit = _classesService.getClassById(id);

        List<Project> classProject =  projectService.getProjectsByClassesId(id);
        StudentProject studentProjectForm = studentProjectService.getStudentProjectById(id);
        List<Project> projects = projectService.getAllProjects();
        List<User> students = _classesService.findUsersByClassId(id);

       // Project formModel = projectService.getProjectById(id);

        model.addAttribute("classToEdit", classToEdit);
        model.addAttribute("classSubject", subject);
        model.addAttribute("teachers", users);
        model.addAttribute("newSetting", setting);
        model.addAttribute("classProject", classProject);
        model.addAttribute("classStudent", students);
        model.addAttribute("lstProject", projects);



        List<Classes> classes = _classesService.GetAllClasses();
        model.addAttribute("lstClass", classes);

        model.addAttribute("projectForm", formModel); // Truyền đối tượng Project mới
        model.addAttribute("studentProjectForm", studentProjectForm);
        return "Class/EditClass";
    }


    @PostMapping("/saveProject")
    public String save(@ModelAttribute("projectForm") Project project) {
        projectService.saveProject(project);
        return "redirect:/projectmember/";
    }

    @PostMapping("/saveStudentProject")
    public String saveStudentProject(@ModelAttribute("studentProjectForm") StudentProject project2) {
        studentProjectService.saveStudentProject(project2);
        return "redirect:/projectmember/";
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
