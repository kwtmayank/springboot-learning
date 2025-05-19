package com.learning.springboot.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.learning.springboot.jpa.DTO.CustomerDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer", schema = "USER_SCHEMA")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "customerCache")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 6)
    private int customerId;
    private String customerName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_address_id")
    private CustomerAddress customerAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id_fk", referencedColumnName = "customerId")
    private List<OrderDetails> orderList = new ArrayList<>();


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderDetails> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDetails> orderList) {
        this.orderList = orderList;
    }

    public CustomerDTO getCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId((long) this.customerId);
        customerDTO.setCustomerName(this.customerName);
        customerDTO.setCustomerAddress(this.customerAddress.getAddressLine1() + this.customerAddress.getAddressLine2() + this.customerAddress.getCity() + this.customerAddress.getState() + this.customerAddress.getCountry() + this.customerAddress.getPostalCode());
        return customerDTO;
    }

}
