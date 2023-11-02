package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.StudentClass;
import com.example.IMS_BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentClassRepository extends JpaRepository<StudentClass,Long> {
    public List<StudentClass> findAllByStudent(User user);
}
