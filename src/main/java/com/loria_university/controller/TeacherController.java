package com.loria_university.controller;

import com.loria_university.entity.Teacher;
import com.loria_university.service.facultyService.FacultyService;
import com.loria_university.service.studentService.StudentService;
import com.loria_university.service.teacherService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/loria/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final FacultyService facultyService;
    private final StudentService studentService;

    @Autowired
    public TeacherController(TeacherService teacherService, FacultyService facultyService, StudentService studentService) {
        this.teacherService = teacherService;
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @GetMapping("")
    public String showAllTeachers(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers/teachers";
    }

    @GetMapping("/addNewTeacher")
    public String addNewTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "teachers/teachers-form";
    }

    @GetMapping("/saveTeacher")
    public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult, @RequestParam("faculty_id") int facultyId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "teachers/teachers-form";
        } else {
            teacherService.saveTeacher(teacher, facultyId);
            return "redirect:/loria/teachers";
        }
    }

    @GetMapping("/updateTeacher")
    public String updateTeacher(@RequestParam("id") int id, Model model) {
        Teacher teacher = teacherService.getTeacher(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "teachers/teachers-form";
    }

    @GetMapping("/fireTeacher")
    public String fireTeacher(int id) {
        teacherService.fireTeacher(id);
        return "redirect:/loria/teachers";
    }

    @GetMapping("/addStudentsToTeacher")
    public String addStudentsToTeacher(@RequestParam("id") int id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        model.addAttribute("students", studentService.getAllStudents());
        return "teachers/add-students-to-teacher";
    }

    @PostMapping("/addStudentsToTeacher")
    public String addStudentsToTeacher(@RequestParam("teacher_id") int teacherId, @RequestParam("checkedStudents") int[] studentsId) {
        teacherService.addStudentsToTeacher(teacherId, studentsId);
        return "redirect:/loria/teachers";
    }

    @GetMapping("/removeStudentsOfTeacher")
    public String removeStudentsOfTeacher(@RequestParam("id") int id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        model.addAttribute("students", teacherService.getTeacher(id).getStudents());
        return "teachers/remove-students-of-teacher";
    }

    @PostMapping("/removeStudentsOfTeacher")
    public String removeStudentsOfTeacher(@RequestParam("teacher_id") int teacherId, @RequestParam("checkedStudents") int[] studentsId) {
        teacherService.removeStudentsOfTeacher(teacherId, studentsId);
        return "redirect:/loria/teachers";
    }

    @GetMapping("/getAllStudentsOfTeacher")
    public String showAllStudentsOfTeacher(@RequestParam("id") int id, Model model) {
        model.addAttribute("students", teacherService.getTeacher(id).getStudents());
        return "students/students";
    }

}
