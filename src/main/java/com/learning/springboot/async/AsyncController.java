package com.learning.springboot.async;

import com.learning.springboot.interceptor.MyCustomerAnnotationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;


    @GetMapping
    @MyCustomerAnnotationInterceptor.MyCustomAnnotation(name = "test")
    public String execute() throws InterruptedException {
        System.out.println("Current Thread "+Thread.currentThread().getName());
        asyncService.asyncPrint();
        return "Working";
    }
}


