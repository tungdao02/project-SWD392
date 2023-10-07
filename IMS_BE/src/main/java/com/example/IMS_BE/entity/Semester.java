package com.example.IMS_BE.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="Semester")
public class Semester extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name="description",length = 45)
    private String description;
    @Column(name = "start",nullable = false)
    private Date startdate;
    @Column(name = "end",nullable = false)
    private Date startend;

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
}
