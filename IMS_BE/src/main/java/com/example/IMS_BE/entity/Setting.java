package com.example.IMS_BE.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="Setting")
public class Setting extends BaseEntity{
    @Id
    @Column(name = "setting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false,length = 45)
    private String name;
    @Column(name="type",length = 45)
    private String type;
    @Column(name = "start")
    private Date startdate;
    @Column(name = "end")
    private Date startend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String description) {
        this.type = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
