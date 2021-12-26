package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(long id);

    void remove(long id);
}
