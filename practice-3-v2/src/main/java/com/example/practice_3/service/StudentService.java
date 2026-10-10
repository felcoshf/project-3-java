package com.example.practice_3.service;

import com.example.practice_3.model.Student;
import com.example.practice_3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(String name, String course, Boolean hasDebt) {
        List<Student> all = studentRepository.findAll();
        return all.stream()
                .filter(s -> name == null || s.getName().contains(name))
                .filter(s -> course == null || s.getCourse().equals(course))
                .filter(s -> hasDebt == null || s.getHasDebt().equals(hasDebt))
                .toList();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
