package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepositoryCrud extends CrudRepository<Blog, Integer> {

    @Modifying
    @Query("DELETE FROM Comment c WHERE c.blog.blogId = :blogId")
    void deleteCommentsByBlogId(int blogId);

    @Modifying
    @Query("DELETE FROM Blog b WHERE b.blogId = :blogId")
    void deleteBlogById(int blogId);
}
