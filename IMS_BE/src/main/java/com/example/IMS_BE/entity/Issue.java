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
    @ManyToOne
    @JoinColumn(name = "type",nullable = false,referencedColumnName = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "status",nullable = false,referencedColumnName = "status_id")
    private Status status;
    public Issue() {
    }

    public Issue(Long id, String title, String descripton, User assigner, User assignee, Type type, Status status) {
        this.id = id;
        this.title = title;
        this.descripton = descripton;
        this.assigner = assigner;
        this.assignee = assignee;
        this.type = type;
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public User getAssigner() {
        return assigner;
    }

    public void setAssigner(User assigner) {
        this.assigner = assigner;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descripton='" + descripton + '\'' +
                ", assigner=" + assigner +
                ", assignee=" + assignee +
                '}';
    }
}
