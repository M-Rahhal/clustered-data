package com.progresssoft.clustered_data.logging.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);


    @After("execution(* com.progresssoft.clustered_data..*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method executed: {}", methodName);
        for (Object arg : args) {
            logger.info("Argument: {}", arg);
        }
    }

    @Before("execution(* com.progresssoft.clustered_data..*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("About to execute method: {}", methodName);
        for (Object arg : args) {
            logger.info("Argument: {}", arg);
        }
    }
}