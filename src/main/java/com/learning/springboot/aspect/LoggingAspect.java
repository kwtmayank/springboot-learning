package com.learning.springboot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public String com.learning.springboot.aspect.AspectController.execute())")
    public void loggingAspect(){
        System.out.println("loggingAspect");
    }

    @Before("execution(* com.learning.springboot.aspect.AspectController.execute())")
    public void loggingAnyAspect(){
        System.out.println("loggingAspect any access modifier");
    }

    @Before("execution(* com.learning.springboot.aspect.AspectController.*())")
    public void loggingAnyMethodAspect(){
        System.out.println("loggingAspect any method");
    }


    @Before("execution(* String com.learning.springboot.aspect.AspectController.*(String))")
    public void loggingAnyMethodWithStringAspect(){
        System.out.println("loggingAspect any method with String");
    }

    @Before("within(com.learning.springboot.aspect.AspectController)")
    public void loggingAnyMethodWithinAspect(){
        System.out.println("Within loggingAspect any method before");
    }

    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void loggingAnyMethodWithinController(){
        System.out.println("Within loggingAspect any controller");
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void loggingAnyMethodWithinAnnotation(){
        System.out.println("Within loggingAspect any get mapping");
    }
}
