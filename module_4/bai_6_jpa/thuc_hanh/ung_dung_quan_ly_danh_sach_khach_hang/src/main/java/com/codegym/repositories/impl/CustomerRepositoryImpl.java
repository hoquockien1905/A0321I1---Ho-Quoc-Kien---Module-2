package com.codegym.repositories.impl;

import com.codegym.model.Customer;
import com.codegym.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer model) {
        if (model.getId() != null) {
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer.getId() != null) {
            entityManager.remove(customer);
        }
    }
}
