package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Card() {
    }

    public Card(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
