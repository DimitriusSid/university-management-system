package com.loria_university.service.studentService;

import com.loria_university.dao.studentDAO.StudentDAO;
import com.loria_university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImplementation(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student, int facultyId) {
        studentDAO.saveStudent(student, facultyId);
    }

    @Override
    @Transactional
    public void expelStudent(int id) {
        studentDAO.expelStudent(id);
    }

    @Override
    @Transactional
    public void addTeachersToStudent(int studentId, int[] teachersId) {
        studentDAO.addTeachersToStudent(studentId, teachersId);
    }

    @Override
    @Transactional
    public void removeTeachersOfStudent(int studentId, int[] teachersId) {
        studentDAO.removeTeachersOfStudent(studentId, teachersId);
    }

    @Override
    @Transactional
    public void addBooksToStudent(int studentId, int[] booksId) {
        studentDAO.addBooksToStudent(studentId, booksId);
    }

    @Override
    @Transactional
    public void returnBooksOfStudent(int studentId, int[] booksId) {
        studentDAO.returnBooksOfStudent(studentId, booksId);
    }


}
