package com.loria_university.service.teacherService;

import com.loria_university.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher getTeacher(int id);
    void saveTeacher(Teacher teacher, int facultyId);
    void fireTeacher(int id);
    void addStudentsToTeacher(int teacherId, int[] studentsId);
    void removeStudentsOfTeacher(int teacherId, int[] studentsId);

}
