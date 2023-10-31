package com.example.IMS_BE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Class")
//student_class_mn
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false,referencedColumnName = "user_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "class_id",nullable = false,referencedColumnName = "class_id")
    private Classes classes;

    public StudentClass() {
    }

    public StudentClass(Long id, User student, Classes classes) {
        this.id = id;
        this.student = student;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
