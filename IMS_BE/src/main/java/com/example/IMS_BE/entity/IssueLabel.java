package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Issue_Label")
public class IssueLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "label_id",nullable = false,referencedColumnName = "label_id")
    private Label label;
    @ManyToOne
    @JoinColumn(name = "issue_id",nullable = false,referencedColumnName = "issue_id")
    private Issue issue;
}
