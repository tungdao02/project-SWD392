package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long id;
    @Column(name = "description",length = 45)
    private String description;
    @Column(name = "status",nullable = false,length = 45)
    private String status;
    @Column(name = "color",nullable = false,length = 45)
    private String color;
    @ManyToOne
    @JoinColumn(name = "project_id",nullable = false,referencedColumnName = "project_id")
    private Project project;


}
