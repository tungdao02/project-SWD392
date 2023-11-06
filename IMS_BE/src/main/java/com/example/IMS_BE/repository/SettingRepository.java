package com.example.IMS_BE.repository;

import com.example.IMS_BE.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    Setting findBySettingId(Long id);

    @Query(value = "select DISTINCT `type`  from setting", nativeQuery = true)
    List<String> findAllTypes();
    void deleteAllByIdIn(List<Long> ids);

}
