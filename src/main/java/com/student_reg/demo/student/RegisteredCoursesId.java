package com.student_reg.demo.student;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.student_reg.demo.course.*;

@Embeddable
public class RegisteredCoursesId implements Serializable {

    private Student student;

    private Offerings offering;

    @Basic(optional = false)
    @Column(name = "student_id")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Basic(optional = false)
    @Column(name = "offering_id")
    public Offerings getOffering() {
        return this.offering;
    }

    public void setOffering(Offerings offering) {
        this.offering = offering;
    }

    // public RegisteredCoursesId(Student studentId, Offerings offeringId) {
    // this.studentId = studentId;
    // this.offeringId = offeringId;
    // }

    // @JsonBackReference
    // @ManyToOne
    // @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    // public Student getStudentId() {
    // return this.studentId;
    // }

    // public void setStudentId(Student studentId) {
    // this.studentId = studentId;
    // }

    // @JsonBackReference
    // @ManyToOne
    // @JoinColumn(name = "offeringId", referencedColumnName = "uniqueId")
    // public Offerings getOfferingId() {
    // return this.offeringId;
    // }

    // public void setOfferingId(Offerings offeringId) {
    // this.offeringId = offeringId;
    // }

}
