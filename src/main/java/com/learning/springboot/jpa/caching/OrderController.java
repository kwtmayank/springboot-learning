package com.learning.springboot.jpa.caching;

import com.learning.springboot.jpa.entity.OrderDetails;
import com.learning.springboot.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caching/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderById(@PathVariable int id) {
        OrderDetails orderDetails = orderService.getOrderById((int) id);
        if (orderDetails != null) {
            return ResponseEntity.ok(orderDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails) {
        OrderDetails createdOrderDetails = orderService.createOrder(orderDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> updateOrder(@PathVariable int id, @RequestBody OrderDetails orderDetails) {
        OrderDetails updatedOrderDetails = orderService.updateOrder((int) id, orderDetails);
        if (updatedOrderDetails != null) {
            return ResponseEntity.ok(updatedOrderDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        boolean isDeleted = orderService.deleteOrder(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

