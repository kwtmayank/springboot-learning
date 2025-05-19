package com.learning.springboot.beanscope.singleton;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    public Computer() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Computer Created with id " + this.hashCode());
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Computer Bean destroyed with id " + this.hashCode());
    }
}
