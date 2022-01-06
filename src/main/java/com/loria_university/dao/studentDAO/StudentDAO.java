package com.loria_university.dao.studentDAO;

import com.loria_university.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();
    Student getStudent(int id);
    void saveStudent(Student student, int id);
    void expelStudent(int id);



}
