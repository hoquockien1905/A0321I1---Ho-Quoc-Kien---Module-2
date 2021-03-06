package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer("John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer("Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer("Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer("Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer("Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer("Rose", "rose@codegym.vn", "Newyork"));
    }


    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
//        customers.
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
