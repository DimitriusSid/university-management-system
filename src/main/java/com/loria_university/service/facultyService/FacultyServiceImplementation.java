package com.loria_university.service.facultyService;

import com.loria_university.dao.facultyDAO.FacultyDAO;
import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacultyServiceImplementation implements FacultyService {

    private final FacultyDAO facultyDAO;

    @Autowired
    public FacultyServiceImplementation(FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Override
    @Transactional
    public List<Faculty> getAllFaculties() {
        return facultyDAO.getAllFaculties();
    }

    @Override
    @Transactional
    public List<Teacher> showTeachersOnFaculty(int facultyId) {
        return facultyDAO.showTeachersOnFaculty(facultyId);
    }

    @Override
    @Transactional
    public List<Student> showStudentsOnFaculty(int facultyId) {
        return facultyDAO.showStudentsOnFaculty(facultyId);
    }
}
