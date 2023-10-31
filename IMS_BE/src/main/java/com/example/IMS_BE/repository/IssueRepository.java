package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
List<Issue> findIssuesByAssignee(User user);

}
