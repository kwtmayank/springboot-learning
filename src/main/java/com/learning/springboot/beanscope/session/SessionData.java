package com.learning.springboot.beanscope.session;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionData {


    @PostConstruct
    public void init(){
        System.out.println("Session Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Session Bean destroyed with id "+this.hashCode());
    }

    public SessionData() {
        System.out.println("SessionData class instantiated");
    }
}
