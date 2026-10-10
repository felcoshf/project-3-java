package com.example.practice_3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String course;

    @Column
    private Boolean hasDebt;

    public Student() {
    }

    public Student(String name, String course, Boolean hasDebt) {
        this.name = name;
        this.course = course;
        this.hasDebt = hasDebt;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Boolean getHasDebt() {
        return hasDebt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setHasDebt(Boolean hasDebt) {
        this.hasDebt = hasDebt;
    }

}
