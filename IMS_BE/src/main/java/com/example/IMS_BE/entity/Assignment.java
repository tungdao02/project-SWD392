package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Assignment")
public class Assignment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="assignment_name",length = 100,nullable = false)
    private String name;
    @Column(name = "description",length = 45)
    private String description;
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false,referencedColumnName = "subject_id")
    private Subject subject;

    public Assignment() {
    }

    public Assignment(Long id, String name, String description, Subject subject) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
