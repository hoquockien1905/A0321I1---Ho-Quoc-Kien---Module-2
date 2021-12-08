package com.codegym.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void save(T blog);

    T findById(Long id);

    void remove(Long id);
}
