package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    List<Book> findBookByNameContains(String name);
}
