package com.example.practice_3.controller;

import com.example.practice_3.model.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String listStudents(HttpSession session) {
        if (session.getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }
        return "students-list";
    }

    @GetMapping("/students/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-add-form";
    }


    @PostMapping("/students/add")
    public String addStudent(HttpSession session) {
        if (session.getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }
        return "redirect:/students";
    }
}
