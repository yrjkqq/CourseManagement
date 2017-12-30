package com.cdsxt.dao;

import com.cdsxt.po.Student;

import java.util.List;

public interface StudentDao {

    List<Student> queryAll();

    void add(Student student);
}
