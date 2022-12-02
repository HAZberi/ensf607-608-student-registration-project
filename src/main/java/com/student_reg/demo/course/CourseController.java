package com.student_reg.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses sorted")
    public List<Course> getAllCoursesSorted() {
        return courseService.getAllCoursesSorted();
    }

    @PostMapping
    public void registerNewCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
    }

    @PostMapping("/addCourse")
    public List<Course> checkRegisterNewCourse(@RequestBody Course course) {

        courseService.addNewCourse(course);
        return courseService.getAllCoursesSorted();
    }

    @PostMapping("/search")
    public Course searchCourse(@RequestBody Course course) {
        return courseService.getCourseByCourseId(course.getCourseID());
    }

    @PostMapping("/edit")
    public List<Course> editCourse(@RequestBody Course course, Course newCourse) {
        courseService.updateCourseName(course.getCourseID(), newCourse.getCourseID());
        return courseService.getAllCoursesSorted();
    }

    @PostMapping("/delete")
    public List<Course> deleteCourse(@RequestBody Course course) {
        courseService.deleteCourse(course);
        return courseService.getAllCoursesSorted();
    }

}
