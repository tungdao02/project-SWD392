package com.example.IMS_BE.controller;


import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.SubjectRepository;
import com.example.IMS_BE.repository.UserRepository;
import com.example.IMS_BE.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectRepository productRepo;
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public String subjetcList(){
        return "subject";
    }

    @GetMapping("/add")
        public String subjectAdd(){
        List<User> managerList = userService.findUserList();
        return "subject_add";
        }

    @GetMapping("/details")
    public String subjectDetails(){
        return "subject_detail";
    }

    @PostMapping("/save_subject")
    public String saveSubjects(@ModelAttribute Subject subjects, HttpSession session){

        productRepo.save(subjects);
        session.setAttribute("msg","Subject Add Sucessfully!");
        return "redirect:/add";
    }
}
