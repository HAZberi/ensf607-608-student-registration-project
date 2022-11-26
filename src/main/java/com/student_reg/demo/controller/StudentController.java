package com.student_reg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student_reg.demo.database.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRespository;

    @GetMapping("/student")
    public List<Student> index(){
        return studentRespository.findAll();
    }

    @GetMapping("/byID")
    public Optional<Student> index(Integer id)
    {
        id = 1000000001;
        return studentRespository.findById(id);
    }

    @GetMapping("/byName")
    public Optional<Student> index(String name)
    {
        name = "Hassaan Zuberi";
        return studentRespository.findByStudentName(name);
    }
}

