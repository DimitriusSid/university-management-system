package com.loria_university.controller;

import com.loria_university.entity.Student;
import com.loria_university.service.facultyService.FacultyService;
import com.loria_university.service.libraryService.LibraryService;
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
@RequestMapping("/loria/students")
public class StudentController {

    private final StudentService studentService;
    private final FacultyService facultyService;
    private final TeacherService teacherService;
    private final LibraryService libraryService;

    @Autowired
    public StudentController(StudentService studentService, FacultyService facultyService, TeacherService teacherService, LibraryService libraryService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
        this.teacherService = teacherService;
        this.libraryService = libraryService;
    }

    @GetMapping("")
    public String showAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/students";
    }

    @GetMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "students/students-form";
    }

    @GetMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult, @RequestParam("faculty_id") int facultyId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "students/students-form";
        } else {
            studentService.saveStudent(student, facultyId);
            return "redirect:/loria/students";
        }
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
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "students/students-form";
    }

    @GetMapping("/addTeacherToStudent")
    public String addTeacherToStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("student", studentService.getStudent(id));
        return "students/add-teachers-for-students";
    }

    @PostMapping("/addTeacherToStudent")
    public String addTeacherToStudent(@RequestParam("student_id") int studentId, @RequestParam("checkedTeachers") int[] teachersId)  {
        studentService.addTeachersToStudent(studentId, teachersId);
        return "redirect:/loria/students";
    }

    @GetMapping("/getAllTeachersOfStudent")
    public String showAllTeachersOfStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("teachers", studentService.getStudent(id).getTeachers());
        return "teachers/teachers";
    }

    @GetMapping("/removeTeachersOfStudent")
    public String removeTeachersOfStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("teachers", studentService.getStudent(id).getTeachers());
        model.addAttribute("student", studentService.getStudent(id));
        return "students/remove-teachers-of-student";
    }

    @PostMapping("/removeTeachersOfStudent")
    public String removeTeachersOfStudent(@RequestParam("student_id") int studentId, @RequestParam("checkedTeachers") int[] teachersId) {
        studentService.removeTeachersOfStudent(studentId, teachersId);
        return "redirect:/loria/students";
    }

    @GetMapping("/addBooksToStudent")
    public String addBooksToStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        model.addAttribute("books", libraryService.getAllBooks());
        return "students/add-books-to-student";
    }

    @PostMapping("/addBooksToStudent")
    public String addBookToStudent(@RequestParam("student_id") int studentId, @RequestParam("checkedBooks") int[] booksId) {
        studentService.addBooksToStudent(studentId, booksId);
        return "redirect:/loria/students";
    }

    @GetMapping("/returnBooksOfStudent")
    public String returnBooksOfStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        model.addAttribute("books", studentService.getStudent(id).getBooks());
        return "students/return-books-of-students";
    }

    @PostMapping("/returnBooksOfStudent")
    public String returnBooksOfStudent(@RequestParam("student_id") int studentId, @RequestParam("checkedBooks") int[] booksId) {
        studentService.returnBooksOfStudent(studentId, booksId);
        return "redirect:/loria/students";
    }

    @GetMapping("/getAllBooksOfStudent")
    public String getAllBooksOfStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("books", studentService.getStudent(id).getBooks());
        return "library/books";

    }
}
