package com.learning.springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Address {


    @PostConstruct
    public void init(){
        System.out.println("Address Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Address Bean destroyed with id "+this.hashCode());
    }

    public Address() {
        System.out.println("Address class instantiated");
    }
}
