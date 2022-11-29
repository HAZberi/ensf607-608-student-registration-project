package com.student_reg.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/add")
    public List<Course> checkRegisterNewCourse() {

        Course newCourse = new Course("Math 230", 13);
        courseService.addNewCourse(newCourse);
        return courseService.getAllCoursesSorted();
    }

    @GetMapping("/addNoID")
    public List<Course> checkRegisterNewCourseNoID() {

        Course newCourse = new Course("Math 232");
        courseService.addNewCourse(newCourse);
        return courseService.getAllCoursesSorted();
    }

    @GetMapping("/search")
    public Course searchCourse() {
        return courseService.getCourseByCourseId("CHEM 209");
    }

    @GetMapping("/edit")
    public List<Course> editCourse() {
        courseService.updateCourseName("Math 211", "HIST 211");
        return courseService.getAllCoursesSorted();
    }

    // this needs work - right now only setting to NULL but would need to delete
    // course/offering/registeredcourses/prereq that has this
    @GetMapping("/delete")
    public List<Course> deleteCourse() {
        courseService.deleteCourse(searchCourse());
        return courseService.getAllCoursesSorted();
    }

}

