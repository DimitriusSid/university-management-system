package com.loria_university.service.facultyService;

import com.loria_university.dao.facultyDAO.FacultyDAO;
import com.loria_university.entity.Faculty;
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
}
