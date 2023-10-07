package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name="description",length = 45)
    private String description;
    @OneToOne
    @JoinColumn( name="class_id")
    private Classes classes;
    @OneToOne
    @JoinColumn(name = "teamlead")
    private User user;
}
