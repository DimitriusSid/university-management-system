package com.loria_university.service.studentService;

import com.loria_university.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(int id);
    void saveStudent(Student student, int id);
    void expelStudent(int id);

}
