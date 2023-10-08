package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.service.IssueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @RequestMapping("/student")
    public List<Issue> getListIssue(){
        return issueService.getAllIssue();
    }


}
