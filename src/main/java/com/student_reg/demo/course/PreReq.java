package com.student_reg.demo.course;

import com.student_reg.demo.student.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PreReqs")
public class PreReq {

    private int prereqId;
    private int course;
    private String prereq;

    public PreReq() {
    }

    public PreReq(int prereqId, int course, String prereq) {
        this.prereqId = prereqId;
        this.course = course;
        this.prereq = prereq;
    }

    @Id
    public int getPrereqId() {
        return this.prereqId;
    }

    public void setPrereqId(int prereqId) {
        this.prereqId = prereqId;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPrereq() {
        return this.prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

}
