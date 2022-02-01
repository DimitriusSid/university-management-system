package com.loria_university.service.teacherService;

import com.loria_university.dao.teacherDAO.TeacherDAO;
import com.loria_university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeacherServiceImplementation implements TeacherService{

    private final TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImplementation(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    @Override
    @Transactional
    public Teacher getTeacher(int id) {
        return teacherDAO.getTeacher(id);
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher, int facultyId) {
        teacherDAO.saveTeacher(teacher, facultyId);
    }

    @Override
    @Transactional
    public void fireTeacher(int id) {
        teacherDAO.fireTeacher(id);
    }

    @Override
    @Transactional
    public void addStudentsToTeacher(int teacherId, int[] studentsId) {
        teacherDAO.addStudentsToTeacher(teacherId, studentsId);
    }

    @Override
    @Transactional
    public void removeStudentsOfTeacher(int teacherId, int[] studentsId) {
        teacherDAO.removeStudentsOfTeacher(teacherId, studentsId);
    }

}
