package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    int getIndex(int id);

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);
}
