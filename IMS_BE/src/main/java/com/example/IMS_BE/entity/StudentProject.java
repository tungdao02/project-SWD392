package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Project")
public class StudentProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToOne
    @JoinColumn(name = "class_id")
    private User user;
}
