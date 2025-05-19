package com.learning.springboot.valueannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("onlineOrder")
public class OnlineOrder implements Order {
    @Override
    public String createOrder() {
        String str = "Online Order created";
        System.out.println(str);
        return str;
    }
}
