package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 45)
    private String title;

    @Column(name = "descripton",length = 45)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id",nullable = false,referencedColumnName = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigner_id",nullable = false,referencedColumnName = "user_id")
    private User assigner;

    @ManyToOne
    @JoinColumn(name = "assignee_id",nullable = false,referencedColumnName = "user_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "milestone_id",nullable = false,referencedColumnName = "milestone_id")
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "work_process_id",nullable = false,referencedColumnName = "issue_setting_id")
    private IssueSetting issueSetting;
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false,referencedColumnName = "issue_setting_id")
    private IssueSetting type;
    @ManyToOne
    @JoinColumn(name = "status_id",nullable = false,referencedColumnName = "issue_setting_id")
    private IssueSetting status;

    public Issue() {
    }

    public Issue(Long id, String title, String description, Project project, User assigner, User assignee, Milestone milestone, IssueSetting issueSetting, IssueSetting type, IssueSetting status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.assigner = assigner;
        this.assignee = assignee;

        this.milestone = milestone;
        this.issueSetting = issueSetting;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripton) {
        this.description = descripton;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getAssigner() {
        return assigner;
    }

    public void setAssigner(User assigner) {
        this.assigner = assigner;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }


    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public IssueSetting getIssueSetting() {
        return issueSetting;
    }

    public void setIssueSetting(IssueSetting issueSetting) {
        this.issueSetting = issueSetting;
    }

    public IssueSetting getType() {
        return type;
    }

    public void setType(IssueSetting type) {
        this.type = type;
    }

    public IssueSetting getStatus() {
        return status;
    }

    public void setStatus(IssueSetting status) {
        this.status = status;
    }
}