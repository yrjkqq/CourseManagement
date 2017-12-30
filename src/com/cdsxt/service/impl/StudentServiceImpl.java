package com.cdsxt.service.impl;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void selectCourse(Student student, Set<Course> courseList) {
        // 因为courseList 中的元素都包含主键, 所以可以自动转换为持久态对象, 又处于事务中, 可以直接进行设置, 数据库会同步

        // 清空原集合
        student.getCourses().clear();
        // 设置新集合
        student.setCourses(courseList);
        // 更新选课信息; 已经同步到数据库中, 不需要显示更新
        // this.studentDao.updateCourse(student);
    }

    @Override
    public Student queryById(Integer sid) {
        return studentDao.queryById(sid);
    }

    @Override
    public Set<Course> querySelectedCourses(Integer sid) {
        return studentDao.querySelectedCourses(sid);
    }


}
