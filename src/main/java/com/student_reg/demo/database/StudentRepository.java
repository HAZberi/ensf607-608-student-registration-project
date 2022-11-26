package com.student_reg.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // custom query to search to blog post by title or content
    List<Student> findByStudentNameOrStudentID(String name, Integer id);    
    // List<Student> findByStudentName(String text);    
}

