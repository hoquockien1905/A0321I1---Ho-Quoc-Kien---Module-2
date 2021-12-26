package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);
}
