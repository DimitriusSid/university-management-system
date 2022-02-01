package com.loria_university.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class StudentPointcuts {

    @Pointcut("execution(* com.loria_university.dao.studentDAO.StudentDAOImplementation.saveStudent(..))")
    public void saveStudentMethod() {}

    @Pointcut("execution(* com.loria_university.dao.studentDAO.StudentDAOImplementation.expelStudent(..))")
    public void expelStudentMethod() {}

}
