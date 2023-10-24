package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subject_name",length = 100,nullable = false)
    private String name;
    @Column(name="description",length = 45)
    private String description;
    @Column(name="status",nullable = false,length = 45)
    private String status;
    @ManyToOne
    @JoinColumn(name="manager_id",referencedColumnName = "user_id")
    private User manager;

    public Subject() {
    }

    public Subject(Long id, String name, String description, String status, User manager) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.manager = manager;
    }

    public Subject(String name, String description, String status, User manager) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.manager = manager;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
