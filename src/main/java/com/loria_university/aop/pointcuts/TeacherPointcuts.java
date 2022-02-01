package com.loria_university.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class TeacherPointcuts {

    @Pointcut("execution(* com.loria_university.dao.teacherDAO.TeacherDAOImplementation.saveTeacher(..))")
    public void saveTeacherMethod() {}

    @Pointcut("execution(* com.loria_university.dao.teacherDAO.TeacherDAOImplementation.fireTeacher(..))")
    public void fireTeacherMethod() {}

}
