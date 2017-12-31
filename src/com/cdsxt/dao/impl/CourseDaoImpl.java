package com.cdsxt.dao.impl;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Course> queryAll() {
        return this.getSession().createQuery("from Course c").list();
    }

    @Override
    public void add(Course course) {
        this.getSession().save(course);
    }

    @Override
    public void delete(Course course) {
        this.getSession().delete(course);
    }

    @Override
    public Course queryById(Integer cid) {
        return (Course) this.getSession().get(Course.class, cid);
    }
}
