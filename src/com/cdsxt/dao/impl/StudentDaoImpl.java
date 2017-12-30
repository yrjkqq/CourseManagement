package com.cdsxt.dao.impl;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> queryAll() {
        return this.getSession().createQuery("from Student s").list();
    }

    @Override
    public void add(Student student) {
        this.getSession().save(student);
    }

    // 更新选课信息
    @Override
    public void updateCourse(Student student) {
        this.getSession().update(student);
    }

    @Override
    public Student queryById(Integer sid) {
        return (Student) this.getSession().get(Student.class, sid);
    }

    // 查询所有已选课程
    @Override
    public Set<Course> querySelectedCourses(Integer sid) {
        return ((Student) this.getSession().get(Student.class, sid)).getCourses();
    }


}
