package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class RegisteredCourses {

    private int studentId;
    private int offeringId;

    public RegisteredCourses(int studentId, int offeringId) {
        this.studentId = studentId;
        this.offeringId = offeringId;
    }

    public RegisteredCourses() {
    }

    @Id
    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getOfferingId() {
        return this.offeringId;
    }

    public void setOfferingId(int offeringId) {
        this.offeringId = offeringId;
    }

}