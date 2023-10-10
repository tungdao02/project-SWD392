package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name = "description")
    private String description;
     @Column(name="status",nullable = false)
    private int status;
     @ManyToOne
    @JoinColumn(name = "semester_id",nullable = false,referencedColumnName = "setting_id")
    private Setting setting;
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false,referencedColumnName = "user_id")
    private User teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false,referencedColumnName = "subject_id")
    private Subject subject;
}
