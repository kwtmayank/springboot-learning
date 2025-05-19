package com.learning.springboot.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "database", havingValue = "NOSQL")
@Component
public class NoSQLConnection {

    NoSQLConnection(){
        System.out.println("NoSQLConnection created");
    }
}
