package com.loria_university.aop.aspects;

import com.loria_university.entity.Teacher;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingTeacherAspect {

    private final Logger logger;

    @Autowired
    public LoggingTeacherAspect(Logger logger) {
        this.logger = logger;
    }

    @Around("com.loria_university.aop.pointcuts.TeacherPointcuts.saveTeacherMethod()")
    public Object aroundSaveTeacherAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        Teacher teacher = (Teacher) objects[0];
        int facultyId = (int) objects[1];
        logger.info("Teacher " + teacher.getName() + " with salary " + teacher.getSalary() + " " +
                "was successfully added on faculty with id " + facultyId + "\n// Method " + methodName + " is finished");
        return result;
    }

    @Around("com.loria_university.aop.pointcuts.TeacherPointcuts.fireTeacherMethod()")
    public Object aroundFireTeacherAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info("Method " + methodName + " is started");
        Object result = proceedingJoinPoint.proceed();
        Object[] objects = proceedingJoinPoint.getArgs();
        int teacherId = (int) objects[0];
        logger.info("Teacher with id=" + teacherId + " was successfully deleted\n// Method " + methodName + " is finished");
        return result;
    }

}
