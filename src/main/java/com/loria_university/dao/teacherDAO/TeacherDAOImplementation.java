package com.loria_university.dao.teacherDAO;

import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TeacherDAOImplementation implements TeacherDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public TeacherDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher", Teacher.class).getResultList();
    }

    @Override
    public Teacher getTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public void saveTeacher(Teacher teacher, int facultyId) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, facultyId);
        teacher.setFaculty(faculty);
        session.saveOrUpdate(teacher);
    }

    @Override
    public void fireTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Teacher.class, id));
    }

    @Override
    public void addStudentsToTeacher(int teacherId, int[] studentsId) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, teacherId);
        for (int studentId : studentsId) {
            teacher.addStudentToTeacher(session.get(Student.class, studentId));
        }
    }

    @Override
    public void removeStudentsOfTeacher(int teacherId, int[] studentsId) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, teacherId);
        for (int studentId : studentsId) {
            teacher.removeStudentOfTeacher(session.get(Student.class, studentId));
        }
    }


}
