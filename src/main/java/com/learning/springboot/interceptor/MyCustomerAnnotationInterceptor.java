package com.learning.springboot.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Component
@Aspect
public class MyCustomerAnnotationInterceptor {

    @Target(java.lang.annotation.ElementType.METHOD)
    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface MyCustomAnnotation {
        String name() default "defaultName";
    }


    @Around("@annotation(com.learning.springboot.interceptor.MyCustomerAnnotationInterceptor$MyCustomAnnotation)")
    public void invoke(ProceedingJoinPoint joinPoint) {
        System.out.println("Before method execution");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if(signature.getMethod().isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation myCustomAnnotation = signature.getMethod().getAnnotation(MyCustomAnnotation.class);
            System.out.println(myCustomAnnotation.name());
        }

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        System.out.println("After method execution");


    }

}
