package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.StudentClass;
import com.example.IMS_BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IStudentClassRepository extends JpaRepository<StudentClass,Long> {
    public List<StudentClass> findAllByStudent(User user);

    Optional<StudentClass> findByClassesIdAndStudentId(Long classId, Long userId);
}
