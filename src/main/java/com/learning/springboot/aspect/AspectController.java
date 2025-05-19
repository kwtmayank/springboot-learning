package com.learning.springboot.aspect;

import com.learning.springboot.async.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectController {

    @Autowired
    private AsyncService asyncService;


    @GetMapping
    public String execute() {
        System.out.println("AspectController execute");
        return "Working";
    }
}


