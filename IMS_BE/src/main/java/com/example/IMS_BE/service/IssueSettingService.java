package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.IssueSetting;
import com.example.IMS_BE.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IssueSettingService {
    List<IssueSetting> getAllIssueSetting();
    void addIssueSetting(IssueSetting issueSetting);
    void saveIssueSetting(IssueSetting issueSetting);
    void deleteIssueSettingById(Long id);
    void updateIssueSetting(IssueSetting issueSetting);
    Optional<IssueSetting> findIssueSettingById(Long id);
   // List<IssueSetting> getIsssueSettingByTypeAndProject( Project project,String type);
    List<IssueSetting> getIsssueSettingByTypeAndProject(Long projectid,String type);


}
