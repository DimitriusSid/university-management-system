package com.loria_university.dao.libraryDAO;

import com.loria_university.entity.Book;

import java.util.List;

public interface LibraryDAO {

    List<Book> getAllBooks();
    Book getBook(int id);
    void saveBook(Book book);
    void deleteBook(int id);

}
