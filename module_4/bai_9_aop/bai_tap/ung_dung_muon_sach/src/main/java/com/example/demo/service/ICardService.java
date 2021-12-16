package com.example.demo.service;

import com.example.demo.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICardService {
    List<Card> findAll();

    void save(Card card);

    Card findById(int id);

    void delete(int id);

}
