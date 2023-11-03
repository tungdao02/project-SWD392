package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Classes;
import com.example.IMS_BE.entity.Project;
import com.example.IMS_BE.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes,Long> {
//    @Query("SELECT c.projects FROM Classes c WHERE c.id = :classId")
//    List<Project> findProjectsByClassId(@Param("classId") Long classId);

    @Query("SELECT sc.student FROM StudentClass sc WHERE sc.classes.id = :classId")
    List<User> findUsersByClassId(@Param("classId") Long classId);
}
