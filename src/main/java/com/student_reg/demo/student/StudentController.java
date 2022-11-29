package com.student_reg.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/byID")
    public Student getStudentsByID(Integer id) {
        Student temp = studentService.getStudentById(1001);
        return temp;
    }

    @GetMapping("/byName")
    public Student getStudentsByName(String name) {
        name = "Hassaan Zuberi";
        Student temp = studentService.getStudentByName(name);
        return temp;
    }

    // @Autowired
    // StudentRepository studentRepository;

    // @GetMapping("/student")
    // public List<Student> index() {
    // return studentRepository.findAll();
    // }

    // @GetMapping("/byID")
    // public Optional<Student> index(Integer id) {
    // id = 1001;
    // return studentRepository.findById(id);
    // }

    // @GetMapping("/check")
    // public String doil(Integer id) {
    // id = 1001;
    // return (studentRepository.findById(id)).get().getStudentName();
    // }

    // @GetMapping("/byName")
    // public Optional<Student> index(String name) {
    // name = "Hassaan Zuberi";
    // return studentRepository.findByStudentName(name);
    // }
}
