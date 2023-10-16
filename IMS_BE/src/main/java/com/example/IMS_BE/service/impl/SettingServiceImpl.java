package com.example.IMS_BE.service.impl;

import com.example.IMS_BE.entity.Setting;
import com.example.IMS_BE.repository.SettingRepository;
import com.example.IMS_BE.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    SettingRepository settingRepository;
    @Override
    public List<Setting> getAllSettings() {
        return (List<Setting>) settingRepository.findAll();
    }

    @Override
    public Setting save(Setting entity) {
        return settingRepository.save(entity);
    }

    @Override
    public List<Setting> saveAll(List<Setting> entities) {
        return (List<Setting>)settingRepository.saveAll(entities);
    }

    @Override
    public Optional<Setting> findById(Long aLong) {
        return settingRepository.findById(aLong);
    }

    @Override
    public List<Setting> findAll() {
        return (List<Setting>)settingRepository.findAll();
    }

    @Override
    public List<Setting> findAllById(List<Long> longs) {
        return (List<Setting>)settingRepository.findAllById(longs);
    }

    @Override
    public boolean existsById(Long aLong) {
        return settingRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return settingRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        settingRepository.deleteById(aLong);
    }

    @Override
    public void delete(Setting entity) {
        settingRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Setting> entities) {
        settingRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        settingRepository.deleteAll();
    }
}
