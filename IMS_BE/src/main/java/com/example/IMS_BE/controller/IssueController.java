package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.service.IClassesService;
import com.example.IMS_BE.service.IssueService;

import com.example.IMS_BE.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@Controller
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @Autowired
    private UserService userService;
    @Autowired
    private IClassesService classesService;

    @GetMapping("/student")
    public String getListIssue(Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("USERNAME");
        User user= userService.getUserByUsername(username);
        model.addAttribute("test_name",username);
//        List<Issue> list = issueService.getAllIssueByAssignee(user);
        List<Issue> list = issueService.getAllIssue();
        model.addAttribute("list",list);

        return "issuelist";
    }
    @GetMapping("/{id}")
    public String getIssue(Model model, @PathVariable int id){
//        Issue issue= issueService.getIssueById((int)id);
//        model.addAttribute("issue",issue);

        return "students";
    }



}
