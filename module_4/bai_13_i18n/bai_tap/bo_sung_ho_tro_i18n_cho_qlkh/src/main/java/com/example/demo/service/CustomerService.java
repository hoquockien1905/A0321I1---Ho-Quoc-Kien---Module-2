package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repositories.ICustomerRepository;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        Customer customer = findById(id);
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }
}
