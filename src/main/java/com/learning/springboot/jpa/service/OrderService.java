package com.learning.springboot.jpa.service;

import com.learning.springboot.jpa.entity.OrderDetails;
import com.learning.springboot.jpa.entity.Product;
import com.learning.springboot.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Order operations.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    /**
     * Retrieves an Order by its ID.
     *
     * @param id the ID of the Order to retrieve
     * @return the Order entity, or null if not found
     */
    public OrderDetails getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all Orders.
     *
     * @return a List of all Order entities
     */
    public List<OrderDetails> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Creates a new Order for a Customer.
     *
     * @param orderDetails the Order entity to create
     * @return the created Order entity
     */
    public OrderDetails createOrder(OrderDetails orderDetails) {
        List<Product> productList = orderDetails.getProducts().stream().map(product -> productService.getProduct(product.getId())).toList();
        orderDetails.setProducts(productList);
        return orderRepository.save(orderDetails);

    }

    /**
     * Updates an existing Order.
     *
     * @param id    the ID of the Order to update
     * @param orderDetails the updated Order entity
     * @return the updated Order entity
     */
    public OrderDetails updateOrder(int id, OrderDetails orderDetails) {
        OrderDetails existingOrderDetails = getOrderById(id);
        if (existingOrderDetails != null) {
            orderDetails.setOrderName(orderDetails.getOrderName());
            // Update other fields as needed
            return orderRepository.save(existingOrderDetails);
        } else {
            return null;
        }
    }

    /**
     * Deletes an Order by its ID.
     *
     * @param id the ID of the Order to delete
     * @return
     */
    public boolean deleteOrder(int id) {
        orderRepository.deleteById(id);
        return true;
    }
}
