package com.learning.springboot.profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("QA")
public class StagingAPI {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;


    @PostConstruct
    private  void init(){
        System.out.println("StagingAPI Created with username "+this.username+" and password "+this.password);
    }
}
