package com.loria_university.controller;

import com.loria_university.entity.Book;
import com.loria_university.service.libraryService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("loria/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("")
    public String showAllBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "library/books";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "library/books-form";
    }

    @GetMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        libraryService.saveBook(book);
        return "redirect:/loria/library";
    }

    @GetMapping("/updateBook")
    public String updateBook(@RequestParam("book_id") int id, Model model) {
        Book book = libraryService.getBook(id);
        model.addAttribute("book", book);
        return "library/books-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("book_id") int id) {
        libraryService.deleteBook(id);
        return "redirect:/loria/library";
    }

    @GetMapping("/showStudentsOfBook")
    public String showStudentsOfBook(@RequestParam("book_id") int id, Model model) {
        model.addAttribute("students", libraryService.getBook(id).getStudents());
        return "students/students";
    }
}
