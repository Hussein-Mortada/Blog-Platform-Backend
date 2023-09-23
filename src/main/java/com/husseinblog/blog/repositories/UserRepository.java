package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    User findByUserId(int userId);
}