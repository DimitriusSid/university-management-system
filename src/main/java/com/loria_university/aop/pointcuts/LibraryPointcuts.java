package com.loria_university.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class LibraryPointcuts {

    @Pointcut("execution(* com.loria_university.dao.libraryDAO.LibraryDAOImplementation.getAllBooks(..))")
    public void getAllBooksMethod() {}

    @Pointcut("execution(* com.loria_university.dao.libraryDAO.LibraryDAOImplementation.getBook(..))")
    public void getBookMethod() {}

    @Pointcut("execution(* com.loria_university.dao.libraryDAO.LibraryDAOImplementation.saveBook(..))")
    public void saveBookMethod() {}

    @Pointcut("execution(* com.loria_university.dao.libraryDAO.LibraryDAOImplementation.deleteBook(..))")
    public void deleteBookMethod() {}
}
