package com.loria_university.aop.aspects;

import com.loria_university.entity.Book;
import com.loria_university.service.libraryService.LibraryService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingLibraryAspect {

    private final Logger logger;
    private final LibraryService libraryService;

    @Autowired
    public LoggingLibraryAspect(Logger logger, LibraryService libraryService) {
        this.logger = logger;
        this.libraryService = libraryService;
    }

    @Around("com.loria_university.aop.pointcuts.LibraryPointcuts.getAllBooksMethod()")
    public Object aroundGetAllBooksMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        logger.info("Method " + methodName + " is finished");
        return result;
    }

    @Around("com.loria_university.aop.pointcuts.LibraryPointcuts.getBookMethod()")
    public Object aroundGetBookMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Book book = (Book) result;
        logger.info("Method " + methodName + " is finished\n// Book " + book.getTitle() + " by " +
                book.getAuthorName() + " was gotten for updating");
        return result;
    }

    @Around("com.loria_university.aop.pointcuts.LibraryPointcuts.saveBookMethod()")
    public Object aroundSaveBookMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        String bookAuthorName = "";
        String bookTitle = "";
        int bookPublicationYear = 0;
        for (Object obj : objects) {
            Book book = (Book) obj;
            bookAuthorName = book.getAuthorName();
            bookTitle = book.getTitle();
            bookPublicationYear = book.getYear();
        }
        logger.info("Book with title " + bookTitle + " by " + bookAuthorName + " " + bookPublicationYear + " " +
                "was successfully added/updated " + " \n// method " + methodName + " is finished");
        return result;
    }

    @Around("com.loria_university.aop.pointcuts.LibraryPointcuts.deleteBookMethod()")
    public Object aroundDeleteBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        int bookId = 0;
        for (Object obj : objects) {
            bookId = (Integer) obj;
        }
        logger.info("Book with id " + bookId + " was successfully deleted " +
                "\n// method " + methodName + " is finished");
        return result;
    }


}
