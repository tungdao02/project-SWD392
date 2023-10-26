package com.example.IMS_BE.controller;


import com.example.IMS_BE.entity.Subject;
import com.example.IMS_BE.entity.User;
import com.example.IMS_BE.repository.SubjectRepository;
import com.example.IMS_BE.service.SubjectService;
import com.example.IMS_BE.service.UserService;
import jakarta.jws.WebParam;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showPaginatedSubjects(Pageable pageable, @RequestParam(required = false) String keyword, @RequestParam(required = false) String searchBy, Model model) {
        Page<Subject> page;
        if (keyword != null && searchBy != null) {
            if (searchBy.equals("name")) {
                page = subjectRepository.findByNameContaining(keyword, pageable);
            } else if (searchBy.equals("manager")) {
                page = subjectRepository.findByManager_UsernameContaining(keyword, pageable);
            } else {
                page = subjectRepository.findAll(pageable);
            }
        } else {
            page = subjectRepository.findAll(pageable);
        }
        model.addAttribute("page", page);
        return "subject";
    }

    @GetMapping("/add")
        public String subjectAdd(Model model){
        List<User> managerList = userService.findManagerList();
        model.addAttribute("managerList",managerList);
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "subject_add";
        }

    @GetMapping("/details")
    public String subjectDetails(){
        return "subject_detail";
    }



    @PostMapping("/add")
//    public String saveSubjects(@ModelAttribute Subject subjects, HttpSession session){
//
//        subjectRepository.save(subjects);
//        session.setAttribute("msg","Subject Add Sucessfully!");
//        return "redirect:/subject/list";
//    }

    public String saveSubjects(Subject subject, RedirectAttributes redirectAttributes){
        subjectRepository.save(subject);
        redirectAttributes.addFlashAttribute("message", "The Subject has been saved successfully!");
        return "redirect:/subject/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSubject(@RequestParam("id") Long subjectId, Model model) {
        subjectRepository.deleteById(subjectId);
        return "redirect:/subject/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editSubject(@RequestParam("id") Long subjectId, Model model) {
        Optional<Subject> subjectEdit = subjectRepository.findById(subjectId);
        subjectEdit.ifPresent(subject -> model.addAttribute("subject", subject));
        return "redirect:/subject/list";
    }

}
