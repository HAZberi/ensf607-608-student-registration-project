package com.student_reg.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_reg.demo.student.RegisteredCourses;

import java.util.Optional;
import java.util.Set;
import java.util.List;

@Repository
public interface OfferingsRepository extends JpaRepository<Offerings, Integer> {

    Optional<Offerings> findBycourseId(int id);

    List<Offerings> findByRegisteredCoursesIn(Set<RegisteredCourses> set);
}
