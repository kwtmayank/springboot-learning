package com.learning.springboot.jpa.service;

import com.learning.springboot.jpa.entity.Customer;
import com.learning.springboot.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int saveCustomer(Customer customer) {
        return customerRepository.save(customer).getCustomerId();
    }

    public Customer getCustomer(long id) {
        return customerRepository.findById((int) id).orElse(null);
    }

    public boolean updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(Math.toIntExact(customer.getCustomerId()));
        if(customerOptional.isPresent()){
            customerRepository.save(customer);
        }
        return true;
    }
}
