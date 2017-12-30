package com.cdsxt.service.impl;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void add(Student student) {
        this.studentDao.add(student);
    }
}
