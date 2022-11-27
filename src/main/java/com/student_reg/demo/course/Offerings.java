package com.student_reg.demo.course;

import com.student_reg.demo.student.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offerings {

    private int uniqueId;
    private int courseId;
    private int sectionNo;
    private int capacity;

    public Offerings() {
    }

    public Offerings(int uniqueId, int courseId, int sectionNo, int capacity) {
        this.uniqueId = uniqueId;
        this.courseId = courseId;
        this.sectionNo = sectionNo;
        this.capacity = capacity;
    }

    @Id
    public int getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getSectionNo() {
        return this.sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}