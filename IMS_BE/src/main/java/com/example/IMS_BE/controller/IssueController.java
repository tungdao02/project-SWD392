package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.service.IssueService;

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
    @GetMapping("/student")
    public String getListIssue(Model model){
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
