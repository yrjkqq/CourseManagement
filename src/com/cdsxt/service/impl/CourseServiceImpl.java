package com.cdsxt.service.impl;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> queryAll() {
        return courseDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void add(Course course) {
        this.courseDao.add(course);
    }
}
