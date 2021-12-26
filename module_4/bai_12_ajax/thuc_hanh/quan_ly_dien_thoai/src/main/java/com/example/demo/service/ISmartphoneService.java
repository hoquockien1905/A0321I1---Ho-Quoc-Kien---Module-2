package com.example.demo.service;

import com.example.demo.model.Smartphone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(int id);

    void save(Smartphone smartphone);

    void remove(int id);
}
