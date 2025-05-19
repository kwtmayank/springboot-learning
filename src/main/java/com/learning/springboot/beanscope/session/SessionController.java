package com.learning.springboot.beanscope.session;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/session")
@Scope("session")
public class SessionController {


    @Autowired
    private SessionData sessionData;

    @PostConstruct
    public void init(){
        System.out.println("SessionController Created with id "+this.hashCode());
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("SessionController Bean destroyed with id "+this.hashCode());
    }

    public SessionController() {
        System.out.println("SessionController initialized");
//        System.out.println("Person id is "+person.hashCode());
//        System.out.println("Address id is "+address.hashCode());
    }

    @GetMapping
    public String getRequest(){
        return "Session";
    }


    @GetMapping("/logout")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("Session ended");
        return "OK";

    }
}
