package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private  Long id;
    @Column(name="name",length = 45)
    private String name;
    @Column(name="description",length = 45)
    private String description;
    @ManyToOne
    @JoinColumn( name="class_id",nullable = false,referencedColumnName = "class_id")
    private Classes classes;
    @ManyToOne
    @JoinColumn(name = "teamlead_id",nullable = false,referencedColumnName = "user_id")
    private User user;
}
