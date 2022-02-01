package com.loria_university.service.libraryService;

import com.loria_university.entity.Book;

import java.util.List;

public interface LibraryService {

    List<Book> getAllBooks();
    Book getBook(int id);
    void saveBook(Book book);
    void deleteBook(int id);
}
