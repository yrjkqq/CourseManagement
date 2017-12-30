package com.cdsxt.service;

import com.cdsxt.po.Course;

import java.util.List;

public interface CourseService {

    List<Course> queryAll();

    void add(Course course);
}
