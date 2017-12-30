package com.cdsxt.dao.impl;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
