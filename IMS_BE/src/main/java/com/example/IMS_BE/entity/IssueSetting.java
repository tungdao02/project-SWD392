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


}
