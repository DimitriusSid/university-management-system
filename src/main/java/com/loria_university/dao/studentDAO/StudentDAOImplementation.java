package com.loria_university.dao.studentDAO;

import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void saveStudent(Student student, int id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, id);
        student.setFaculty(faculty);
        session.saveOrUpdate(student);
    }

    @Override
    public void expelStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class, id));
    }
}
