package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repositories.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByAuthorContains(String name, Pageable pageable) {
        return blogRepository.findAllByAuthorContains(name, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(int id, Pageable p) {
        return blogRepository.findAllByCategory(id, p);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            blogRepository.delete(blog);
        }
    }
}
