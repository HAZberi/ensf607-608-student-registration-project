package com.student_reg.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final OfferingsRepository offeringsRepository;
    private final PreReqRepository preReqRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, OfferingsRepository offeringsRepository,
            PreReqRepository preReqRepository) {
        this.courseRepository = courseRepository;
        this.offeringsRepository = offeringsRepository;
        this.preReqRepository = preReqRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<String> getAllCoursesNames() {
        List<Course> courses = courseRepository.findAll();
        List<String> courseNames = new ArrayList<String>();
        for (int i = 0; i < courses.size(); i++) {
            courseNames.add(courses.get(i).getCourseID());
        }

        return courseNames;
    }

    public List<Course> getAllCoursesSorted() {
        return courseRepository.findByOrderByCourseIDAsc();
    }

    public void addNewCourse(Course course) {
        Optional<Course> courseByCourseID = courseRepository.findByCourseID(course.getCourseID());
        if (courseByCourseID.isPresent()) {
            throw new IllegalStateException("Course already exists!");
        }
        courseRepository.save(course);
    }

    public Course getCourseByCourseId(String courseId) {
        Optional<Course> courseById = courseRepository.findByCourseID(courseId);
        if (!courseById.isPresent()) {
            throw new IllegalStateException("Course doesn't exist!");
        }
        return courseById.get();
    }

    public void updateCourseName(String courseId, String newCourseId) {
        Optional<Course> courseById = courseRepository.findByCourseID(courseId);
        if (!courseById.isPresent()) {
            throw new IllegalStateException("Course doesn't exist!");
        }

        courseById.get().setCourseID(newCourseId);
    }

    public void deleteCourse(String courseId) {
        Optional<Course> courseByCourseID = courseRepository.findByCourseID(courseId);
        if (!courseByCourseID.isPresent()) {
            throw new IllegalStateException("Course doesn't exist!");
        }
        courseRepository.delete(courseByCourseID.get());
    }

}
