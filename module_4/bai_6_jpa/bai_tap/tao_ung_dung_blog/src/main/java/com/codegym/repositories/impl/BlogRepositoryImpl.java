package com.codegym.repositories.impl;

import com.codegym.model.Blog;
import com.codegym.repositories.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager.createNamedQuery("getAllBlog").getResultList();
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
