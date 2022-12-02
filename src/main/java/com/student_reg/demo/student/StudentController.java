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
    public List<Course> registeredCourses(@RequestBody Integer id) {

        return studentService.registeredCourseList(id);
    }

    @PostMapping("/offeringList")
    public List<Offerings> registeredOfferings(@RequestBody Integer id) {
        return studentService.registeredOfferingList(id);
    }

    @PostMapping("/registerCourse")
    public List<Course> registerForCourse(@RequestBody RegisteredCourses regCourse) {
        studentService.registerForCourse(regCourse.getStudentId(),
                regCourse.getOfferingId());

        return studentService.registeredCourseList(regCourse.getStudentId().getStudentId());
    }

    @PostMapping("/deregisterCourse")
    public List<Course> deregisterFromCourse(@RequestBody ArrayList<Integer> id) {
        int studentId = id.get(0);
        int offeringId = id.get(1);
        studentService.deregisterFromCourse(studentId, offeringId);

        return studentService.registeredCourseList(studentId);
    }
}
