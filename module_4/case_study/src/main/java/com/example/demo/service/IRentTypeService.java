package com.example.demo.service;

import com.example.demo.model.services.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRentTypeService {
    List<RentType> findAll();
}
