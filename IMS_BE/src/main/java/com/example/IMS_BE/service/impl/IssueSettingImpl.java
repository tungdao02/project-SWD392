package com.example.IMS_BE.service.impl;


import com.example.IMS_BE.entity.IssueSetting;
import com.example.IMS_BE.repository.IIssueSettingRepository;
import com.example.IMS_BE.service.IssueSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IssueSettingImpl implements IssueSettingService {

    @Autowired
    IIssueSettingRepository issueSettingRepository;

    @Override
    public List<IssueSetting> getAllIssueSetting() {
        return issueSettingRepository.findAll();
    }

    @Override
    public void addIssueSetting(IssueSetting issueSetting) {

    }

    @Override
    public void saveIssueSetting(IssueSetting issueSetting) {
        issueSettingRepository.save(issueSetting);
    }

    @Override
    public void deleteIssueSettingById(Long id) {

    }

    @Override
    public void updateIssueSetting(IssueSetting issueSetting) {

    }

    @Override
    public Optional<IssueSetting> findIssueSettingById(Long id) {
        return issueSettingRepository.findById(id);
    }
}
