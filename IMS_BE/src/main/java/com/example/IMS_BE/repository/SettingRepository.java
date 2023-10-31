package com.example.IMS_BE.repository;

import java.util.*;
import com.example.IMS_BE.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    public List<Setting> findByType(String type);
}
