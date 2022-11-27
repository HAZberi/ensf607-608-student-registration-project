package com.student_reg.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        Optional<Course> courseByCourseID = courseRepository.findByCourseID(course.getCourseID());
        if (courseByCourseID.isPresent()) {
            throw new IllegalStateException("Course already exist!");
        }
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseByCourseId(String courseId) {
        Optional<Course> courseById = courseRepository.findByCourseID(courseId);
        if (!courseById.isPresent()) {
            throw new IllegalStateException("Course doesn't exist!");
        }
        return courseById.get();
    }
}
