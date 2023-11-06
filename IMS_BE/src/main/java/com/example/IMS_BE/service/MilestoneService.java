package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Milestone;
import com.example.IMS_BE.entity.Project;

import java.util.List;

public interface MilestoneService {
    List<Milestone> getMilestoneByProject(Project project);
}
