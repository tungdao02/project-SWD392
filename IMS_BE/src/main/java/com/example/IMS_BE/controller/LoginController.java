package com.example.IMS_BE.controller;

import com.example.IMS_BE.entity.Setting;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.SettingRepository;
import com.example.IMS_BE.repository.UserRepository;
import com.example.IMS_BE.service.SettingService;
import com.example.IMS_BE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private SettingService settingService;


    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("checklogin")
    public String checkLogin(ModelMap model, @RequestParam("username")String username, @RequestParam("password")String password,
                             HttpSession session   ){
        if(userService.checkLogin(username,password)){
            System.out.println("Login thanh cong");
            if(userService.isAdmin(username)) {
                session.setAttribute("USERNAME", username);
                List<Setting> settings = settingService.getAllSettings();
                model.addAttribute("settings", settings);
                return "admin_home";
            }else{
                return "redirect:/issue/student";
            }
        }else{
            System.out.println("Login that bai");
            model.addAttribute("ERROR","Username or password not exist!!");
        }
        return "login";
    }

    @RequestMapping("admin_home")
    public String list(ModelMap modelMap, HttpSession session){
        if(session.getAttribute("USERNAME")!=null){
            modelMap.addAttribute("USERNAME","");
            String username = (String) session.getAttribute("USERNAME");
            boolean isAdmin = userService.isAdmin(username);

            if (isAdmin) {
                List<Setting> settings = settingService.getAllSettings();
                modelMap.addAttribute("settings", settings);
                return "admin_home";
            }
        }
        return "access_denied";
    }



    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


}





















































//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
//        if (userService.validateUser(username, password)) {
//            session.setAttribute("username", username);
//            return "redirect:/home";
//        } else {
//            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không chính xác");
//            return "login";
//        }
//    }
//
//    @GetMapping("/home")
//    public String home(HttpSession session, Model model) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            model.addAttribute("username", username);
//            return "home";
//        } else {
//            return "redirect:/login";
//        }
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/login";
//    }


