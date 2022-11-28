package com.student_reg.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferingsRepository extends JpaRepository<Offerings, Integer> {

    Optional<Offerings> findBycourseId(int id);
}
