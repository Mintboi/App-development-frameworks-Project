package com.example.assignment_ChatGPT.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.assignment_ChatGPT.Controllers.*.*(..))")
    public void logBeforeControllerMethods() {
        System.out.println("Controller method executed");
    }
}
