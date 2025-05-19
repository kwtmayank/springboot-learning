package com.learning.springboot.jpa.service;

import com.learning.springboot.jpa.entity.Product;
import com.learning.springboot.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }

}
