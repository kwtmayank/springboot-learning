package com.learning.springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Person {

    private Address address;

    @PostConstruct
    public void init(){
        System.out.println("Person Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Person Bean destroyed with id "+this.hashCode());
    }

    @Autowired
    public Person(Address address) {
        this.address = address;
        System.out.println("Person initialized with address "+address.hashCode());
        System.out.println("Person id is "+this.hashCode());
    }
}
