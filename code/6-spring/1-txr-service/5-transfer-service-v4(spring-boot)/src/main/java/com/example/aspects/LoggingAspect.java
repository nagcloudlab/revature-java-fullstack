package com.example.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

//    @Before(value = "execution(* com.example.service.*.*(..))")
//    public void beforeLog(JoinPoint joinPoint){
//        log.info("Before - "+joinPoint.toLongString());
//    }
//
//    @AfterReturning(value = "execution(* com.example.service.*.*(..))")
//    public void afterReturningLog(JoinPoint joinPoint){
//        log.info("AfterReturning - "+joinPoint.toLongString());
//    }
//
//    @AfterThrowing(value = "execution(* com.example.service.*.*(..))")
//    public void afterThrowingLog(JoinPoint joinPoint){
//        log.info("AfterThrowing - "+joinPoint.toLongString());
//    }
//
//    @After(value = "execution(* com.example.service.*.*(..))")
//    public void afterLog(JoinPoint joinPoint){
//        log.info("After - "+joinPoint.toLongString());
//    }

    @Around(value = "execution(* com.example.service.*.*(..))")
    public void aroundLog(ProceedingJoinPoint proceedingJoinPoint){
        try {
            log.info("Before - ");
            proceedingJoinPoint.proceed();
            log.info("AfterReturning");
        }catch (Throwable t){
            log.info("AfterThrowing");
        }finally {
            log.info("After");
        }

    }

}
