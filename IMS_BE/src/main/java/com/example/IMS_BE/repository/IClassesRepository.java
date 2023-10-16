package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes,Long> {
}
