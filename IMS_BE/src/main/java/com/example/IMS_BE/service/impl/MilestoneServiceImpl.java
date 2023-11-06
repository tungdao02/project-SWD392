package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Milestone;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.repository.IMilestoneRepository;
import com.example.IMS_BE.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MilestoneServiceImpl implements MilestoneService {
    @Autowired
    IMilestoneRepository milestoneRepository;
    @Override
    public List<Milestone> getMilestoneByProject(Project project) {
        return milestoneRepository.findAllByProject(project);
    }

    @Override
    public List<Milestone> getAllMilestone() {
        return milestoneRepository.findAll();
    }
}
