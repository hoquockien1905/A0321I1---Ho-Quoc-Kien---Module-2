package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect{
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution( * com.example.demo.service.BookService.*(..))")
    public void bookService(){}

    @Before("bookService()")
    public void getLog(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("Before: Call: " + methodName + " - And Class: " + className);
    }

    @After("execution(* com.example.demo.service.BookServiceImpl.getList())")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable{
        String methodname = joinPoint.getSignature().getName();
        logger.info("After: End call: " + methodname);
    }

    @Around("bookService()")
    public Object getLogAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around: Begin call: " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around: After call: " + methodName);
        return result;
    }

    @AfterReturning("execution(* com.example.demo.service.BookServiceImpl.fi*(..))")
    public void getLogAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After Returning: Call: "  + methodName);
    }
}
