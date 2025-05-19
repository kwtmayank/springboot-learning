package com.learning.springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @PostConstruct
    public void init(){
        System.out.println("Student Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Student Bean destroyed with id "+this.hashCode());
    }
}
