package com.learning.springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@Scope("request")
public class RequestController {

    @Autowired
    private Person person;

    @Autowired
    private Address address;

    @PostConstruct
    public void init(){
        System.out.println("Address Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Address Bean destroyed with id "+this.hashCode());
    }

    public RequestController() {
        System.out.println("RequestController initialized");
//        System.out.println("Person id is "+person.hashCode());
//        System.out.println("Address id is "+address.hashCode());
    }

    @GetMapping
    public String getRequest(){
        return "Hello";
    }
}
