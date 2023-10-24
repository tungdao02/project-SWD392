package com.example.IMS_BE.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name="status",nullable = false)
    private int status;
    @ManyToOne
    @JoinColumn(name = "semester_id",nullable = false,referencedColumnName = "setting_id")
    private Setting setting;
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false,referencedColumnName = "user_id")
    private User teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false,referencedColumnName = "subject_id")
    private Subject subject;
    @Column(name = "start")
    private Date startdate;
    @Column(name = "end")
    private Date startend;

    public Classes() {
    }

    public Classes(Long id, String name, String description, int status, Setting setting, User teacher, Subject subject, Date startdate, Date startend) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.setting = setting;
        this.teacher = teacher;
        this.subject = subject;
        this.startdate = startdate;
        this.startend = startend;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStartend() {
        return startend;
    }

    public void setStartend(Date startend) {
        this.startend = startend;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", setting=" + setting +
                ", teacher=" + teacher +
                ", subject=" + subject +
                ", startdate=" + startdate +
                ", startend=" + startend +
                '}';
    }
}
