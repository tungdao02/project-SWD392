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
    @Column(name="type",nullable = false,length = 45)
    private String type;

    public Setting() {
    }

    public Setting(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }


    public long getId(){
        return id;
    }

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

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
