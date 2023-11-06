package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Issue;
import com.example.IMS_BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
List<Issue> findAllByAssignee(User user);
    @Query(value = "SELECT i.class_id, COUNT(i.class_id) * 100 / (SELECT COUNT(*) FROM issue WHERE assignee_id = :assigneeId) AS num FROM issue i WHERE i.assignee_id = :assigneeId GROUP BY i.class_id", nativeQuery = true)
    List<Object[]> getClassStatisticsByAssignee(@Param("assigneeId") Long assigneeId);

}
