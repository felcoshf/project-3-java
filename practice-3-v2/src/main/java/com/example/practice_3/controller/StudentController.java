package com.example.practice_3.controller;

import com.example.practice_3.model.Student;
import com.example.practice_3.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) Boolean hasDebt,
            Model model,
            HttpSession session) {

        if (session.getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }

        List<Student> students = studentService.getAllStudents(name, course, hasDebt);
        model.addAttribute("students", students);

        return "students-list";
    }

    @GetMapping("/students/add")
    public String showAddForm(Model model, HttpSession session) {
        if (session.getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }
        model.addAttribute("student", new Student());
        return "student-add-form";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute("student") Student student, HttpSession session) {
        if (session.getAttribute("isLoggedIn") == null) {
            return "redirect:/login";
        }
        studentService.saveStudent(student);

        return "redirect:/students";
    }
}