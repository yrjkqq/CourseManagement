package com.cdsxt.service.impl;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void delete(Course course) {
        // 清空学生: 因为是由学生维护外键关系, 所以直接清空学生集合无法删除;
        // 应该让学生集合的每个元素在其课程集合中去掉当前课程对象, 然后再删除
        for (Student student : course.getStudents()) {
            student.getCourses().remove(course);
        }
        this.courseDao.delete(course);
    }

    @Override
    public Course queryById(Integer cid) {
        return this.courseDao.queryById(cid);
    }
}
