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
        return studentRepository.findByNameAndCourse(name, course);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
