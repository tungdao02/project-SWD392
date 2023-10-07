package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name = "description")
    private String description;
     @Column(name="status")
    private int status;
     @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
