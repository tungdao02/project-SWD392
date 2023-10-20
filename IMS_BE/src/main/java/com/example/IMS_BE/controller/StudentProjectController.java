package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.service.impl.ProjectService;
import com.example.IMS_BE.service.impl.StudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentproject")
public class StudentProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private StudentProjectService studentProjectService;

    @GetMapping("/")
    public String index(@RequestParam(value = "id", required = false, defaultValue = "") String id, Model model) {
        Project formModel = Project.builder().build();

        if (!id.isEmpty()) {
            Long projectId = Long.valueOf(id);
            formModel = projectService.getProjectById(projectId);
        }

       // List<Project> projects = projectService.getAllProjects();
        List<StudentProject> studentProjects = studentProjectService.getAllStudentProjects();
        model.addAttribute("studentProjects", studentProjects);
      //  model.addAttribute("userlist", userlist);
        model.addAttribute("projectForm", formModel);

        return "studentproject";
    }



    @PostMapping("/save")
    public String save(@ModelAttribute("projectForm") Project project) {

    //    Integer studentprojectId = Math.toIntExact(project);
     //   StudentProjectService studenproject = studentProjectService.getStudentProjectById(studentprojectId);

        projectService.saveProject(project);
        return "redirect:/projects/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects/";
    }
}