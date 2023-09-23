package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.Blog;
import com.husseinblog.blog.models.Industry;
import com.husseinblog.blog.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAllByUser(User user);

    @Transactional
    void deleteByBlogId(int blogId);
    List<Blog> findAllByIndustry(Industry industry);


}