package com.loria_university.service.libraryService;

import com.loria_university.dao.libraryDAO.LibraryDAO;
import com.loria_university.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibraryServiceImplementation implements LibraryService{

    private final LibraryDAO libraryDAO;

    @Autowired
    public LibraryServiceImplementation(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return libraryDAO.getAllBooks();
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        return libraryDAO.getBook(id);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        libraryDAO.saveBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        libraryDAO.deleteBook(id);
    }
}
