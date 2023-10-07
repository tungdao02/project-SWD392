package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Assignment")
public class Assignment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "subject_id",nullable = false)
//    private int subject_id;
    @Column(name = "description",length = 45)
    private String description;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}
