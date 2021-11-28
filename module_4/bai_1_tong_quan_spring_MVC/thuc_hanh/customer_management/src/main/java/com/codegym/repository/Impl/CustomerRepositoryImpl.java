package com.codegym.repository.Impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Hieu", "hieu@gmail.com", "DN"));
        customerList.add(new Customer(2, "Hai", "hai@gmail.com", "QN"));
        customerList.add(new Customer(3, "Hoang", "hoang@gmail.com", "HCM"));
        customerList.add(new Customer(4, "Hung", "hung@gmail.com", "HN"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, String name, String email, String address) {
        Customer customer = findById(id);
        if (customer != null) {
            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
        }
    }
}
