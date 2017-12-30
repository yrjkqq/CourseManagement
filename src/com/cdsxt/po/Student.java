package com.cdsxt.po;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test_student")
public class Student {

    @Id
    @SequenceGenerator(name = "studentGen", sequenceName = "seq_test_student")
    @GeneratedValue(generator = "studentGen")
    private Integer sid;
    private String sname;

    @ManyToMany
    @JoinTable(
            name = "test_student_course",
            joinColumns = {
                    @JoinColumn(name = "sid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "cid")
            }
    )
    private Set<Course> courses = new HashSet<>();

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
