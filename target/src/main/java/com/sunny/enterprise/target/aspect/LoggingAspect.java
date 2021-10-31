package com.sunny.enterprise.target.aspect;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("@annotation(LogRequestResponse)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        LOGGER.info(joinPoint.getTarget() + " executed in " + executionTime + "ms");
        return proceed;
    }
}