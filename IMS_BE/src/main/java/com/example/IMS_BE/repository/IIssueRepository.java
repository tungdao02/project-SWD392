package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIssueRepository  extends JpaRepository<Issue,Long> {
    @Query("select issue from Issue issue where issue.assignee.id=?1")
    List<Issue> findByAssigneeId(Long assigneeId);
}
