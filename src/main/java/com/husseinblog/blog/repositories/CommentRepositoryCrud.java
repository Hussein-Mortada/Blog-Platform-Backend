package com.husseinblog.blog.repositories;

import com.husseinblog.blog.models.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepositoryCrud extends CrudRepository<Comment, Integer> {

    @Modifying
    @Query("DELETE FROM Comment c WHERE c.commentId = :commentId")
    void deleteCommentById(int commentId);

}
