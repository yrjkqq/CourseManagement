package com.cdsxt.dao;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;

import java.util.List;
import java.util.Set;

public interface StudentDao {

    List<Student> queryAll();

    void add(Student student);

    // 更新学生选课信息
    void updateCourse(Student student);

    // 根据学生主键进行查询
    Student queryById(Integer sid);

    // 查询已选课程
    Set<Course> querySelectedCourses(Integer sid);
}
