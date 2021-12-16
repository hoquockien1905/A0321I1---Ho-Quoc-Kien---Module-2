package com.example.demo.service.impl;

import com.example.demo.model.Card;
import com.example.demo.repositories.CardRepository;
import com.example.demo.service.IBookService;
import com.example.demo.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    IBookService bookService;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public void save(Card card) {
        cardRepository.save(card);
    }

    @Override
    public Card findById(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        Card card = findById(id);
        if (card != null) {
            cardRepository.delete(card);
        }
    }

}