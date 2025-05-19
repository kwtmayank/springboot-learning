package com.learning.springboot.jpa.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/execution")
public class ExecutionController {

    @Autowired
    ExecutionComponent executionComponent;

    @GetMapping
    public String execute(){
        executionComponent.execute();
        return "Working";
    }
}
