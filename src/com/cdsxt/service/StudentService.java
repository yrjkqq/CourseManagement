package com.cdsxt.service;

import com.cdsxt.po.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryAll();

    void add(Student student);
}
