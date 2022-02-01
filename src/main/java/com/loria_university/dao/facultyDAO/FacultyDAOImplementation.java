package com.loria_university.dao.facultyDAO;

import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;
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

    @Override
    public List<Teacher> showTeachersOnFaculty(int facultyId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher where faculty_id = :facultyId", Teacher.class).setParameter("facultyId", facultyId).getResultList();
    }

    @Override
    public List<Student> showStudentsOnFaculty(int facultyId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student where faculty_id = :facultyId", Student.class).setParameter("facultyId", facultyId).getResultList();
    }

}
