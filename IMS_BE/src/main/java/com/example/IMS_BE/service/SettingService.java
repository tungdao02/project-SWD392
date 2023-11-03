package com.example.IMS_BE.service;

import com.example.IMS_BE.entity.Setting;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

public interface SettingService {
    List<Setting> getAllSettings();

    Setting save(Setting entity);

    List<Setting> saveAll(List<Setting> entities);

    Optional<Setting> findById(Long aLong);

    List<Setting> findAll();

    List<Setting> findAllById(List<Long> longs);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Setting entity);

    void deleteAll(List<Setting> entities);

    void deleteAll();

    List<Setting> findAllByType (String type);
}
