package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Milestone;
import com.example.IMS_BE.entity.StudentProject;
import com.example.IMS_BE.service.IProjectService;
import com.example.IMS_BE.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/milestone")
public class MilestoneController {
    @Autowired
    MilestoneService milestoneService;
    @Autowired
    IProjectService projectService;
        @GetMapping("/api/milestoneByProject/{id}")
    public ResponseEntity<List<Milestone>> getMilestoneByProject(@PathVariable Long id){
        return new ResponseEntity<List<Milestone>> ( milestoneService.getMilestoneByProject(projectService.getProjectById(id)), HttpStatus.OK);
    }
}
