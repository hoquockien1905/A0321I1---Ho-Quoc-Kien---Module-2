package com.example.demo.repositories;

import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
