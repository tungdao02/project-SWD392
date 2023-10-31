package com.example.IMS_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IMS_BE.entity.Milestone;

public interface IMilestoneRepository extends JpaRepository<Milestone,Long>{
    
}
