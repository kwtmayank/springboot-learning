package com.learning.springboot.jpa.jdbc;

import com.learning.springboot.jpa.entity.OrderDetails;
import com.learning.springboot.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public OrderDetails createOrder(OrderDetails orderDetails){
        return orderService.createOrder(orderDetails);
    }
}
