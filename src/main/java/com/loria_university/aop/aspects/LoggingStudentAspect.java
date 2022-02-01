package com.loria_university.aop.aspects;

import com.loria_university.entity.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingStudentAspect {

    private final Logger logger;

    @Autowired
    public LoggingStudentAspect(Logger logger) {
        this.logger = logger;
    }


    @Around("com.loria_university.aop.pointcuts.StudentPointcuts.saveStudentMethod()")
    public Object aroundSaveStudentAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        Student student = (Student) objects[0];
        int facultyId = (int) objects[1];
        logger.info("Student " + student.getName() + "was successfully added on faculty with id "
                + facultyId + "\n// Method " + methodName + " is finished");
        return result;
    }

    @Around("com.loria_university.aop.pointcuts.StudentPointcuts.expelStudentMethod()")
    public Object aroundFireStudentAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        int studentId = (int) objects[0];
        logger.info("Student with id=" + studentId + " was successfully deleted\n// Method " + methodName + " is finished");
        return result;
    }
}
