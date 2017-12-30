package com.cdsxt.service;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {

    List<Student> queryAll();

    void add(Student student);

    void selectCourse(Student student, Set<Course> courseList);

    Student queryById(Integer sid);

    // 查询已选课程
    Set<Course> querySelectedCourses(Integer sid);
}
