package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.Blog;
import com.husseinblog.blog.models.Comment;
import com.husseinblog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

    List<Comment> findAllByBlog(Blog blog);
    List<Comment> findAllByUser(User user);

    void deleteAllByBlog(Blog blog);
}