package com.loria_university.controller;

import com.loria_university.entity.Faculty;
import com.loria_university.entity.Student;
import com.loria_university.entity.Teacher;
import com.loria_university.service.facultyService.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/loria/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("")
    public String showAllFaculties(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "faculties/faculties";
    }

    @GetMapping("/teachersOnFaculty")
    public String showAllTeachersOnFaculty(@RequestParam("faculty_id") int facultyId, Model model) {
        List<Teacher> teachers = facultyService.showTeachersOnFaculty(facultyId);
        model.addAttribute("teachers", teachers);
        return "teachers/teachers";
    }

    @GetMapping("/studentsOnFaculty")
    public String showAllStudentsOnFaculty(@RequestParam("faculty_id") int facultyId, Model model) {
        List<Student> students = facultyService.showStudentsOnFaculty(facultyId);
        model.addAttribute("students", students);
        return "students/students";
    }



}
