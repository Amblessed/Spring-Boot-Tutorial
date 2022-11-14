package com.bright.springboot.controller;


import com.bright.springboot.model.Student;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")         //  http://localhost:8082/student
    public Student getStudent(){
        return new Student("Ramesh", "Fadatare");
    }

    @GetMapping("/students")    //  http://localhost:8082/students
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        Name name = new Faker().name();
        students.add(new Student(name.firstName(), name.lastName()));
        students.add(new Student(name.firstName(), name.lastName()));
        students.add(new Student(name.firstName(), name.lastName()));
        students.add(new Student(name.firstName(), name.lastName()));
        students.add(new Student(name.firstName(), name.lastName()));
        return students;
        
    }
}
