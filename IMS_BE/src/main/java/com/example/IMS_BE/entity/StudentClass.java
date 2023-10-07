package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "student_id")
    private User student;
    @OneToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

}
