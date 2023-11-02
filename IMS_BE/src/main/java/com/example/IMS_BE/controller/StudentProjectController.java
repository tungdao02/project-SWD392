package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.service.UserService;
import com.example.IMS_BE.service.impl.ClassesService;
import com.example.IMS_BE.service.impl.ProjectService;
import com.example.IMS_BE.service.impl.StudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projectmember")
public class StudentProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassesService classService;


    @Autowired
    private StudentProjectService studentProjectService;

    @GetMapping("/")
    public String index(@RequestParam(value = "id", required = false, defaultValue = "") String id, Model model) {
        Project formModel = Project.builder().build();

        if (!id.isEmpty()) {
            Long projectId = Long.valueOf(id);
            formModel = projectService.getProjectById(projectId);
        }

         StudentProject formModel2 = StudentProject.builder().build();

        if (!id.isEmpty()) {
            Long projectId = Long.valueOf(id);
            formModel2 = studentProjectService.getStudentProjectById(projectId);
        }


        List<Classes> classes = classService.GetAllClasses();
        List<User> users = userService.getAllUsers();
        List<Project> projects = projectService.getAllProjects();
        List<StudentProject> studentProjects = studentProjectService.getAllStudentProjects();


        model.addAttribute("studentProjects", studentProjects);
        model.addAttribute("lstClass", classes);
        model.addAttribute("lstUser", users);
        model.addAttribute("lstProject", projects);

        model.addAttribute("projectForm", formModel);
        model.addAttribute("studentProjectForm", formModel2);

        return "projectmember";
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


    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        Project project = projectService.getProjectById(id);
        List<Classes> classes = classService.GetAllClasses();
        List<User> users = userService.getAllUsers();
        List<StudentProject> studentProjects = studentProjectService.getAllStudentProjects();


        model.addAttribute("member", studentProjects);

        model.addAttribute("project", project);
        model.addAttribute("lstClass", classes);
        model.addAttribute("lstUser", users);

        return "editproject";
    }


    @PostMapping("/removeStudentFromProject")
    public String removeStudentFromProject(@ModelAttribute("studentProjectForm") StudentProject studentProject) {
        Long projectId = studentProject.getProject().getId();
        Long studentId = studentProject.getUser().getId();

       // studentProjectService.removeStudentProject(studentId);
        return "redirect:/projectmember/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentProjectService.deleteStudentProject(id);
        return "redirect:/projectmember/";
    }
}