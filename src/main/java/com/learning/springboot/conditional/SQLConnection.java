package com.learning.springboot.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "database", havingValue = "SQL")
@Component
public class SQLConnection {

    SQLConnection(){
        System.out.println("SQLConnection Created");
    }
}
