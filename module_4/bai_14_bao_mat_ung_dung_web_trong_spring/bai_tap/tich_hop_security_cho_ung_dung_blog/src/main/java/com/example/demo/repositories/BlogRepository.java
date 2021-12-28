package com.example.demo.repositories;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByAuthorContains(String name, Pageable pageable);

    @Query(value="SELECT * FROM bai7_blog.blog LEFT JOIN bai7_blog.category ON blog.category_id = category.id WHERE category.id = :id", nativeQuery=true)
    Page<Blog> findAllByCategory(@Param("id") int id, Pageable p);
}
