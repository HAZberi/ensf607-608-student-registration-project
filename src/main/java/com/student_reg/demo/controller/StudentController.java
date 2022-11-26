package com.student_reg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student_reg.demo.database.*;

import java.util.List;
import java.util.Map;

public class StudentController {

    @Autowired
    StudentRepository studentRespository;

    @GetMapping("/student")
    public List<Student> index(){
        return studentRespository.findAll();
    }
}
