package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Setting;
import com.example.IMS_BE.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {

    @Autowired
    private SettingRepository settingRepository;

    @GetMapping("/edit/{id}")
    public String editSetting(@PathVariable Long id, Model model) {
        Setting setting = settingRepository.findById(id).orElse(null);
        if (setting != null) {
            model.addAttribute("setting", setting);
            return "edit"; // Trả về trang chỉnh sửa
        } else {
            // Xử lý trường hợp không tìm thấy Setting
            return "not_found"; // Trả về trang thông báo "Không tìm thấy"
        }
    }

    @PostMapping("/edit/{id}")
    public String updateSetting(@PathVariable Long id, @ModelAttribute Setting updatedSetting) {
        // Xử lý việc cập nhật Setting với thông tin từ updatedSetting
        Setting existingSetting = settingRepository.findById(id).orElse(null);
        if (existingSetting != null) {
            existingSetting.setName(updatedSetting.getName());
            existingSetting.setType(updatedSetting.getType());
            settingRepository.save(existingSetting);
        }
        return "redirect:/admin_home";
    }

    @GetMapping("/delete/{id}")
    public String deleteSetting(@PathVariable Long id) {
        // Xử lý việc xóa Setting
        settingRepository.deleteById(id);
        return "redirect:/admin_home";
    }
}
