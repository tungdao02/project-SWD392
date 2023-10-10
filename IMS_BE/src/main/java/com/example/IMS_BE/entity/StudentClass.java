package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false,referencedColumnName = "user_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "class_id",nullable = false,referencedColumnName = "class_id")
    private Classes classes;

}
