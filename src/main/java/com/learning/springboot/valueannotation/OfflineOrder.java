package com.learning.springboot.valueannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("offlineOrder")
public class OfflineOrder implements Order {
    @Override
    public String createOrder() {
        String str = "Offline Order Created";
       // System.out.println(str);
        return str;
    }
}
