package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {


    @Query( value = "SELECT setting.name \n" +
            "FROM user\n" +
            "JOIN setting ON user.role_id = setting_id\n" +
            "where phone = ?1" , nativeQuery = true)
    String findRolesByPhone(String phone);

    @Query( value = "SELECT setting.name\n" +
            "            FROM user\n" +
            "            JOIN setting ON user.role_id = setting_id\n" +
            "            where email = ?1 " , nativeQuery = true)
    String findRolesByEmail(String email);

    User findById(int id);

    User findByUsername(String username);


    User findByPhone(String phone);

    User findByEmail(String email);

}

