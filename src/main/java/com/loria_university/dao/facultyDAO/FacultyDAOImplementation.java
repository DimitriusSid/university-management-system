package com.loria_university.dao.facultyDAO;

import com.loria_university.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDAOImplementation implements FacultyDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public FacultyDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Faculty", Faculty.class).getResultList();
    }


}
