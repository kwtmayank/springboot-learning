package com.learning.springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {

    @PostConstruct
    public void init(){
        System.out.println("Use Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("User Bean destroyed with id "+this.hashCode());
    }
}


