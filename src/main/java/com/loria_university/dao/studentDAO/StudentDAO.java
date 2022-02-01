package com.loria_university.dao.studentDAO;

import com.loria_university.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();
    Student getStudent(int id);
    void saveStudent(Student student, int facultyId);
    void expelStudent(int id);
    void addTeachersToStudent(int studentId, int[] teachersId);
    void removeTeachersOfStudent(int studentId, int[] teachersId);
    void addBooksToStudent(int studentId, int[] booksId);
    void returnBooksOfStudent(int studentId, int[] booksId);



}
