package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Issue;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IssueService {
    public List<Issue> getAllIssue();
    public List<Issue> getAllIssueById(int id);
    public void addIssue(Issue issue);
    public void deleteIssue(Issue issue);
    public void updateIssue(Issue issue);
    public Issue getIssueById(int id);
}
