package com.cdsxt.dao;

import com.cdsxt.po.Course;

import java.util.List;

public interface CourseDao {

    List<Course> queryAll();

    void add(Course course);

    void delete(Course course);

    Course queryById(Integer cid);
}
