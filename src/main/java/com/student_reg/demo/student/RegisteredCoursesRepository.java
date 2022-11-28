package com.student_reg.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredCoursesRepository extends JpaRepository<RegisteredCourses, Integer> {

    Optional<RegisteredCourses> findBystudentId(Integer id);

    Optional<RegisteredCourses> findByofferingId(Integer id);
}