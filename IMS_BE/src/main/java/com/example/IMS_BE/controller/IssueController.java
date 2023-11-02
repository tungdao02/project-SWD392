package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.entity.StudentClass;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.IStudentClassService;
import com.example.IMS_BE.service.IssueService;

import com.example.IMS_BE.service.UserService;
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
    private IssueService issueService;
    @Autowired
    private UserService userService;
    @Autowired
    IStudentClassService studentClassService;
    @Autowired
    private IClassesService classesService;

    @GetMapping("/student")
    public String getListIssue(Model model, HttpSession session, HttpServletRequest request){
        session=request.getSession();
        String email=session.getAttribute("USERNAME").toString();
        User user = userService.getUserByEmail(email);
        model.addAttribute("user",user);

        List<Issue> list = issueService.getAllIssueByAssignee(user);
        System.out.println(list);
       // List<Issue> list = issueService.getAllIssue();
        model.addAttribute("list",list);

        return "issuelist";
    }
    @GetMapping("/student/add")
    public String addIssue(Model model,HttpSession session, HttpServletRequest request){
        session=request.getSession();
        String email=session.getAttribute("USERNAME").toString();
        User user = userService.getUserByEmail(email);
        model.addAttribute("user",user);
        List<StudentClass> listClass = studentClassService.getClassesByUser(user);
        model.addAttribute("listclass",listClass);
        model.addAttribute("issue", new Issue());
        return "newissue";
    }
    @PostMapping("/student/add")
    public String addIssue(Model model){
//        Issue issue= issueService.getIssueById((int)id);
//        model.addAttribute("issue",issue);

        return "newissue";
    }
    @GetMapping("/{id}")
    public String getIssue(Model model, @PathVariable int id){
//        Issue issue= issueService.getIssueById((int)id);
//        model.addAttribute("issue",issue);

        return "students";
    }



}
