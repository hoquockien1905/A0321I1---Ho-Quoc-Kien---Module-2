package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void update(int id, String name, String email, String address);

    Customer findById(int id);
}
