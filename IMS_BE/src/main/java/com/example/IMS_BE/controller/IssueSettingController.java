package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.*;
import com.example.IMS_BE.repository.IIssueSettingRepository;
import com.example.IMS_BE.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/issue_setting")
public class IssueSettingController {
    @Autowired
    private IIssueSettingRepository issueSettingRepository;
    @Autowired
    private IssueSettingService issueSettingService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IClassesService classesService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public String index(Model model) {
        List<IssueSetting> issueSettings = issueSettingService.getAllIssueSetting();
        model.addAttribute("issueSettings", issueSettings);

        return "issue_setting";
    }

    @GetMapping("/add")
    public String issueSettingAdd(Model model){
        List<Project> projectList = projectService.getAllProjects();
        List<Subject> subjectList = subjectService.getAllSubject();
        List<Classes> classesList = classesService.GetAllClasses();
        model.addAttribute("projectList",projectList );
        model.addAttribute("subjectList",subjectList );
        model.addAttribute("classesList",classesList );
        IssueSetting issueSetting = new IssueSetting();
        model.addAttribute("issueSetting", issueSetting);

        return "issue_setting_add";
    }

    @PostMapping("/add")
    public String saveIssueSetting(IssueSetting issueSetting){
        issueSettingService.saveIssueSetting(issueSetting);
        return "redirect:/issue_setting/list";
    }



}
