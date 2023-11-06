package com.example.IMS_BE.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="Setting")
public class Setting extends BaseEntity{
    @Id
    @Column(name = "setting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingId;
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

    public Long getId() {
        return settingId;
    }

    public void setId(Long id) {
        this.settingId = id;

    }
}
