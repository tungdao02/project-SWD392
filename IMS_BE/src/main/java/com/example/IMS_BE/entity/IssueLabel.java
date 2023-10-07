package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Issue_Label")
public class IssueLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "label_id")
    private Label label;
    @OneToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
