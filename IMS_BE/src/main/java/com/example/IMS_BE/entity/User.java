package com.example.IMS_BE.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")

public class User extends BaseEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",nullable = false, length = 12)
    private String name;
    @Column(name = "phone",nullable = false, length = 12)
    private String phone;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "status",nullable = false)
    private int status;
    @ManyToOne
    @JoinColumn (name = "role_id",nullable = false,referencedColumnName = "setting_id")
    private Setting role;

}
