package com.student_reg.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // custom query to search to blog post by title or content
    Optional<Student> findByStudentNameOrStudentID(String name, Integer id);    
    Optional<Student> findByStudentName(String name);  
    //List<Student> findByStudentName(String text);    
}

