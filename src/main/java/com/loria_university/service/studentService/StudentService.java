package com.loria_university.service.studentService;

import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(int id);
    void saveStudent(Student student, int facultyId);
    void expelStudent(int id);
    void addTeachersToStudent(int studentId, int[] teachersId);
    void removeTeachersOfStudent(int studentId, int[] teachersId);
    void addBooksToStudent(int studentId, int[] booksId);
    void returnBooksOfStudent(int studentId, int[] booksId);

}
