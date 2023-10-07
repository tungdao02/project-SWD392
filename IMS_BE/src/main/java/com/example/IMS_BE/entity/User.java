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
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private int status;
    @Column(name = "role")
    private int role;

}
