package com.example.IMS_BE.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="issue_setting")
public class IssueSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="issue_setting_id")
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name="type",nullable = false)
    private String type;
    @ManyToOne
    @JoinColumn(name = "project_id",nullable = false,referencedColumnName = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false,referencedColumnName = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "class_id",nullable = false,referencedColumnName = "class_id")
    private Classes classes;

    public IssueSetting() {
    }

    public IssueSetting(Long id, String name, String type, Project project, Subject subject, Classes classes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.project = project;
        this.subject = subject;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}