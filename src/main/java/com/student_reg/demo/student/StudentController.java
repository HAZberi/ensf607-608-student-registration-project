package com.student_reg.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    public List<Student> index() {
        return studentRepository.findAll();
    }

    @GetMapping("/byID")
    public Optional<Student> index(Integer id) {
        id = 1001;
        return studentRepository.findById(id);
    }

    @GetMapping("/check")
    public String doil(Integer id) {
        id = 1001;
        return (studentRepository.findById(id)).get().getStudentName();
    }

    @GetMapping("/byName")
    public Optional<Student> index(String name) {
        name = "Hassaan Zuberi";
        return studentRepository.findByStudentName(name);
    }
}
