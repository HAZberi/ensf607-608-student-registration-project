package com.student_reg.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student_reg.demo.course.Course;
import com.student_reg.demo.course.Offerings;
import com.student_reg.demo.course.OfferingsRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

    @PostMapping("/byID")
    public Student getStudentsByID(@RequestBody Student student) {
        Student temp = studentService.getStudentById(student.getStudentId());
        return temp;
    }

    @PostMapping("/byName")
    public Student getStudentsByName(@RequestBody Student student) {
        Student temp = studentService.getStudentByName(student.getStudentName());
        return temp;
    }

    @PostMapping("/registeredList")
    public List<Course> registeredCourses(@RequestBody Student student) {

        return studentService.registeredCourseList(student.getStudentId());
    }

    @PostMapping("/offeringList")
    public List<Offerings> registeredOfferings(@RequestBody Student student) {
        return studentService.registeredOfferingList(student.getStudentId());
    }

    @PostMapping("/registerCourse")
    public List<Course> registerForCourse(@RequestBody RegisteredCourses regCourse) {
        studentService.registerForCourse(regCourse.getStudentId(),
                regCourse.getOfferingId());

        return studentService.registeredCourseList(regCourse.getStudentId().getStudentId());
    }

    @PostMapping("/deregisterCourse")
    public List<Course> deregisterFromCourse(@RequestBody RegisteredCourses regCourse) {

        studentService.deregisterFromCourse(regCourse.getStudentId().getStudentId(),
                regCourse.getOfferingId().getOfferingId());

        return studentService.registeredCourseList(regCourse.getStudentId().getStudentId());
    }
}
