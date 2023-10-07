package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="description",length = 45)
    private String description;
    @Column(name="status",length = 45)
    private String status;
}
