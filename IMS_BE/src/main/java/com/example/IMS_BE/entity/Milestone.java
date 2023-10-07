package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name = "description",length = 45)
    private String description;
    @Column(name = "status",nullable = false,length = 45)
    private String status;
    @Column(name = "color",nullable = false,length = 45)
    private String color;
    @OneToOne
    @JoinColumn(name = "project_id")
    private  Project project;


}
