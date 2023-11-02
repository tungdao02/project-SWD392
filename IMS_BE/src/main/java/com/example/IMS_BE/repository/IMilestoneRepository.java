package com.example.IMS_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IMS_BE.entity.Milestone;
import org.springframework.stereotype.Repository;

@Repository
public interface IMilestoneRepository extends JpaRepository<Milestone,Long>{
    

}
