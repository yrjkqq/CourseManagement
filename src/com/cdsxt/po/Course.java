package com.cdsxt.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "test_course")
public class Course {

    @Id
    @SequenceGenerator(name = "courseGen", sequenceName = "seq_test_course")
    @GeneratedValue(generator = "courseGen")
    private Integer cid;
    private String cname;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(cid, course.cid) &&
                Objects.equals(cname, course.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname);
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
