package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.repository.IssueRepository;
import com.example.IMS_BE.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> getAllIssue() {
        return (List<Issue>)issueRepository.findAll() ;
    }

    @Override
    public List<Issue> getAllIssueById(int id) {
        return (null);
    }

    @Override
    public void addIssue(Issue issue) {
        issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(Issue issue) {

    }

    @Override
    public void updateIssue(Issue issue) {

    }

    @Override
    public Issue getIssueById(int id) {
//        Optional<Issue> issue= issueRepository.findById((long)id);
//        if(issue!=null){
//            return  issue;
//        }
      return null;
    }
}
