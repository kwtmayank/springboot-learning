package com.learning.springboot.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Order createOrderBean(@Value("${orderDetails}") String order) {
        if(order.equals("online")) {
            return new OnlineOrder();
        } else {
            return new OfflineOrder();
        }
    }
}
