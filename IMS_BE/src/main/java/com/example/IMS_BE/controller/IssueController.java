package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.*;
import com.example.IMS_BE.repository.IIssueSettingRepository;
import com.example.IMS_BE.service.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/issue")
public class IssueController {
    @Autowired
     IssueService issueService;
    @Autowired
     UserService userService;
    @Autowired
    IStudentClassService studentClassService;
    @Autowired
     IClassesService classesService;
    @Autowired
    IProjectService projectService;
    @Autowired
    MilestoneService milestoneService;
    @Autowired
    IssueSettingService issueSettingService;

    @GetMapping("/student")
    public String getListIssue(Model model, HttpSession session, HttpServletRequest request){
        session=request.getSession();
        String email=session.getAttribute("USERNAME").toString();
        User user = userService.getUserByEmail(email);
        model.addAttribute("user",user);
        List<Issue> list = issueService.getAllIssueByAssignee(user);
        model.addAttribute("list",list);
        return "Issue/issuelist";
    }
    @GetMapping("/student/add")
    public String addIssue(Model model,HttpSession session, HttpServletRequest request){
        session=request.getSession();
        String email=session.getAttribute("USERNAME").toString();
        User user = userService.getUserByEmail(email);
        model.addAttribute("assignerissue",user);
        List<StudentClass> listClass = studentClassService.getClassesByUser(user);
        List<Project> projectList= projectService.getAllProjects();
        List<Milestone> milestoneList=milestoneService.getAllMilestone();
        List<IssueSetting> statusList=issueSettingService.getIsssueSettingByTypeAndProject((long) 1,"Status");

        List<IssueSetting> processList=issueSettingService.getIsssueSettingByTypeAndProject((long) 1,"Process");
        List<IssueSetting>typeList=issueSettingService.getIsssueSettingByTypeAndProject((long) 1,"type");
        model.addAttribute("listclass",listClass);
        model.addAttribute("projectList",projectList);
        model.addAttribute("milestoneList",milestoneList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("processList",processList);
        model.addAttribute("typeList",typeList);
        model.addAttribute("issue", new Issue());
        return "Issue/newissue";
    }
    @PostMapping("/student/add")
    public String addIssue(Model model,@ModelAttribute Issue issue){
        issueService.addIssue(issue);

        return "redirect:/issue/student";
    }
    @GetMapping("/{id}")
    public String getIssue(Model model, @PathVariable int id){
        Issue issue= issueService.getIssueById((int)id);
        model.addAttribute("issue",issue);
        return "Issue/issuedetail";
    }



}
