package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false,length = 45)
    private String title;
    @Column(name = "descripton",length = 45)
    private String descripton;
    @OneToOne
    @JoinColumn(name = "assigner_id")
    private User assigner;
    @OneToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;
}
