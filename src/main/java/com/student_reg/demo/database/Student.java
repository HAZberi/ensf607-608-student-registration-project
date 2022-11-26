package com.student_reg.demo.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Entity
public class Student {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private int id;

    private int StudentID;

    private String StudentName;
   

    public Student() {  }

    public Student(int StudentID, String StudentName){
        this.setStudentID(StudentID);
        this.setStudentName(StudentName);
    }

    // public Student(int id,int StudentID, String StudentName){
    //     this.setId(id);
    //     this.setStudentID(StudentID);
    //     this.setStudentName(StudentName);
    // }

    // @Id
    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    @Id
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Column(name="StudentName")
    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + StudentID +
                ", StudentName='" + StudentName + "'" +
                '}';
    }

    @Autowired
    StudentRepository studentRespository;

}