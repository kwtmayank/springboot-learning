package com.learning.springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanscope/")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoypeScopeController {

    @Autowired
    private Student student;

    @Autowired
    private User user;

    @PostConstruct
    public void init(){
        System.out.println("BeanScopeController Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("BeanScopeController Bean destroyed with id "+this.hashCode());
    }

    @GetMapping(path = "/getStudent")
    public String getStudent(){
        return "Hello";
    }


}
