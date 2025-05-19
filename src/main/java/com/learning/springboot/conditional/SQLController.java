package com.learning.springboot.conditional;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class SQLController {

    @Autowired(required = false)
    private NoSQLConnection noSQLConnection;

    @Autowired(required = false)
    private SQLConnection sqlConnection;


    @PostConstruct
    public void init() {
        System.out.println("NoSQLConnection: " + noSQLConnection);
        System.out.println("SQLConnection: " + sqlConnection);
    }
}
