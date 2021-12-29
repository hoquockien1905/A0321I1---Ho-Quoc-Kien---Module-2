package com.example.demo.repositories;

import com.example.demo.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    @Query("SELECT ur.role.name FROM UserRole ur WHERE ur.user.userId = :userId")
    List<String> findAllRoleByUser(Integer userId);
}
