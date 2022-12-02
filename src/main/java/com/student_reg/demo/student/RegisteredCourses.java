package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.student_reg.demo.course.*;

@Entity
public class RegisteredCourses implements Serializable {

    private int registeredId;

    private Student studentId;

    private Offerings offeringId;

    public RegisteredCourses() {
    }

    public RegisteredCourses(Student studentId, Offerings offeringId) {
        this.studentId = studentId;
        this.offeringId = offeringId;
    }

    public RegisteredCourses(int registeredId, Student studentId, Offerings offeringId) {
        this.registeredId = registeredId;
        this.studentId = studentId;
        this.offeringId = offeringId;
    }

    @Id
    public int getRegisteredId() {
        return this.registeredId;
    }

    public void setRegisteredId(int registeredId) {
        this.registeredId = registeredId;
    }

    @JsonBackReference(value = "offerings-regcourse")
    @ManyToOne
    @JoinColumn(name = "offeringId")
    public Offerings getOfferingId() {
        return this.offeringId;
    }

    public void setOfferingId(Offerings offering) {
        this.offeringId = offering;
    }

    @JsonBackReference(value = "student-regcourse")
    @ManyToOne
    @JoinColumn(name = "studentId")
    public Student getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Student student) {
        this.studentId = student;
    }

}