package com.student_reg.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student_reg.demo.course.Course;
import com.student_reg.demo.course.Offerings;
import com.student_reg.demo.course.OfferingsRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
        name = "Aaron Warner";
        Student temp = studentService.getStudentByName(name);
        return temp;
    }

    @GetMapping("/registeredList")
    public List<Course> registeredCourses(Integer id) {
        id = 1001;

        return studentService.registeredCourseList(id);
    }

    @GetMapping("/offeringList")
    public List<Offerings> registeredOfferings(Integer id) {
        id = 1001;

        return studentService.registeredOfferingList(id);
    }

    @GetMapping("/registerCourse")
    public List<Course> registerForCourse(Integer studentId, Integer offeringId) {
        studentId = 1001;
        offeringId = 9;
        studentService.registerForCourse(studentId, offeringId);

        return studentService.registeredCourseList(studentId);
    }

    @GetMapping("/deregisterCourse")
    public List<Course> deregisterFromCourse(Integer studentId, Integer registerId) {
        studentId = 1001;
        registerId = 50;
        studentService.deregisterFromCourse(studentId, registerId);

        return studentService.registeredCourseList(studentId);
    }
}
