package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public interface BlogService {
    Iterable<Blog> findAll();

    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findAllByAuthorContains(String name, Pageable pageable);

    Page<Blog> findAllByCategory(@Param("id") int id, Pageable p);

    void save(Blog blog);

    Blog findById(int id);

    void delete(int id);
}
