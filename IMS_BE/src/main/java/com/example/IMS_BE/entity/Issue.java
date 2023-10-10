package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false,length = 45)
    private String title;
    @Column(name = "descripton",length = 45)
    private String descripton;
    @ManyToOne
    @JoinColumn(name = "assigner_id",nullable = false,referencedColumnName = "user_id")
    private User assigner;
    @ManyToOne
    @JoinColumn(name = "assignee_id",nullable = false,referencedColumnName = "user_id")
    private User assignee;
}
