package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void remove(Long id);
}
