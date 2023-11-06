package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.IssueSetting;
import com.example.IMS_BE.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IIssueSettingRepository extends JpaRepository<IssueSetting, Long> {
//    List<IssueSetting> findAllByByProjectAndType(Project project, String type);
@Query("SELECT is FROM IssueSetting is " +
        "WHERE is.project.id = :projectId " +
        "AND is.type = :type")
    List<IssueSetting> findAllByProjectAndType(@Param("projectId") Long projectId,
                                        @Param("type") String type);
}
