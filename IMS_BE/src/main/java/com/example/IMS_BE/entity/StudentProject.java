package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Project")
public class StudentProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "project_id",nullable = false,referencedColumnName = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable=false,referencedColumnName = "user_id")
    private User user;
}
