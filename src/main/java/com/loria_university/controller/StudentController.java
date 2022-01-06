package com.loria_university.controller;

import com.loria_university.entity.Student;
import com.loria_university.service.facultyService.FacultyService;
import com.loria_university.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loria/students")
public class StudentController {

    private final StudentService studentService;
    private final FacultyService facultyService;

    @Autowired
    public StudentController(StudentService studentService, FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @GetMapping("")
    public String showAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "students-form";
    }

    @GetMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("newStudent") Student student, @RequestParam("fac_id") int facultyId) {
        studentService.saveStudent(student, facultyId);
        return "redirect:/loria/students";
    }

    @GetMapping("/expelStudent")
    public String expelStudent(@RequestParam("id") int id) {
        studentService.expelStudent(id);
        return "redirect:/loria/students";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") int id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "students-form";
    }



}
