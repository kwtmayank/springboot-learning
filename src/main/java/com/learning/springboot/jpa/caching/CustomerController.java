package com.learning.springboot.jpa.caching;

import com.learning.springboot.jpa.DTO.CustomerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.springboot.jpa.entity.Customer;
import com.learning.springboot.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caching/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id).getCustomerDTO();
    }

    @PutMapping("/update")
    public boolean updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @PostMapping("/save")
    public long saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}



