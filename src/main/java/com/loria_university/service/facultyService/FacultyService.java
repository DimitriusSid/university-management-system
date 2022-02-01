package com.loria_university.service.facultyService;

import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;

import java.util.List;

public interface FacultyService {

    List<Faculty> getAllFaculties();
    List<Teacher> showTeachersOnFaculty(int facultyId);
    List<Student> showStudentsOnFaculty(int facultyId);
}
