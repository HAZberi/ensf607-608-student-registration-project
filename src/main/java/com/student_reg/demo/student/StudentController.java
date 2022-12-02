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
    public Student getStudentsByID(@RequestBody Integer id) {
        Student temp = studentService.getStudentById(id);
        return temp;
    }

    @GetMapping("/byName")
    public Student getStudentsByName(String name) {
        name = "Aaron Warner";
        Student temp = studentService.getStudentByName(name);
        return temp;
    }

    @PostMapping("/registeredList")
    public List<Course> registeredCourses(@RequestBody Integer id) {

        return studentService.registeredCourseList(id);
    }

    @PostMapping("/offeringList")
    public List<Offerings> registeredOfferings(@RequestBody Integer id) {
        return studentService.registeredOfferingList(id);
    }

    @PostMapping("/registerCourse")
    public List<Course> registerForCourse(@RequestBody ArrayList<Integer> id) {
        int studentId = id.get(0);
        int offeringId = id.get(1);
        studentService.registerForCourse(studentId, offeringId);

        return studentService.registeredCourseList(studentId);
    }

    @PostMapping("/deregisterCourse")
    public List<Course> deregisterFromCourse(@RequestBody ArrayList<Integer> id) {
        int studentId = id.get(0);
        int offeringId = id.get(1);
        studentService.deregisterFromCourse(studentId, offeringId);

        return studentService.registeredCourseList(studentId);
    }
}
