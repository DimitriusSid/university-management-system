package com.loria_university.dao.studentDAO;

import com.loria_university.entity.Book;
import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;
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
    public void saveStudent(Student student, int facultyId) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, facultyId);
        student.setFaculty(faculty);
        session.saveOrUpdate(student);
    }

    @Override
    public void expelStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class, id));
    }

    @Override
    public void addTeachersToStudent(int studentId, int[] teachersId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        for (int teacherId : teachersId) {
            student.addTeacherToStudent(session.get(Teacher.class, teacherId));
        }
    }

    @Override
    public void removeTeachersOfStudent(int studentId, int[] teachersId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        for (int teacherId : teachersId) {
            student.removeTeacherOfStudent(session.get(Teacher.class, teacherId));
        }
    }

    @Override
    public void addBooksToStudent(int studentId, int[] booksId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        for (int bookId : booksId) {
            student.addBookToStudent(session.get(Book.class, bookId));
        }
    }

    @Override
    public void returnBooksOfStudent(int studentId, int[] booksId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        for (int bookId : booksId) {
            student.removeBookOfStudent(session.get(Book.class, bookId));
        }
    }

}
