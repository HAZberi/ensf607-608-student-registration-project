package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.student_reg.demo.course.*;

@Entity
public class RegisteredCourses implements Serializable {

    protected RegisteredCoursesId regId;

    @EmbeddedId
    public RegisteredCoursesId getRegId() {
        return this.regId;
    }

    public void setRegId(RegisteredCoursesId regId) {
        this.regId = regId;
    }

    // @Id
    // public RegisteredCoursesId getregId() {
    // return this.regId;
    // }

    private Student studentId;

    private Offerings offeringId;

    public RegisteredCourses(Student student, Offerings offering) {
        this.studentId = student;
        this.offeringId = offering;
    }

    @JsonBackReference
    @JoinColumn(name = "offering_id", referencedColumnName = "offeringId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Offerings getOfferingId() {
        return this.offeringId;
    }

    public void setOfferingId(Offerings offering) {
        this.offeringId = offering;
    }

    @JsonBackReference
    @JoinColumn(name = "student_id", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Student getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Student student) {
        this.studentId = student;
    }

}