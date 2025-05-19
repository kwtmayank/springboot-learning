package com.learning.springboot.profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PROD")
public class ProductionAPI {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @PostConstruct
    private void init() {
        System.out.println("ProductionAPI created with username " + this.username + " and password " + this.password);
    }
}
