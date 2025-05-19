package com.learning.springboot.beanscope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singleton")
public class SingletonController {

    private Computer computer;

    @Autowired
    public SingletonController(Computer computer) {
        this.computer = computer;
    }

    @GetMapping
    public String getSingleton(){
        return "Singleton";
    }

    @PostConstruct
    public void init(){
        System.out.println("SingletonController Created with id "+this.hashCode());
        System.out.println("Computer object is "+computer.hashCode());
    }


}
