package com.student_reg.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_reg.demo.course.Offerings;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface RegisteredCoursesRepository extends JpaRepository<RegisteredCourses, Integer> {

    Optional<RegisteredCourses> findBystudentId(Integer id);

    Optional<RegisteredCourses> findByofferingId(Integer id);

    @Query(value = "SELECT * FROM RegisteredCourses as rc WHERE rc.studentId=:studentId AND rc.offeringId=:offeringId LIMIT 1", nativeQuery=true)
    Optional<RegisteredCourses> findBystudentIdAndofferingId(Student studentId, Offerings offeringId);
}