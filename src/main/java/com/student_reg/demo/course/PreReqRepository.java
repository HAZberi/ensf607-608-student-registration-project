package com.student_reg.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreReqRepository extends JpaRepository<PreReq, Integer> {

    Optional<PreReq> findByCourse(int id);

    Optional<PreReq> findByprereq(int id);

}
