package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void update(int id, String name, String email, String address);

    Customer findById(int id);
}
