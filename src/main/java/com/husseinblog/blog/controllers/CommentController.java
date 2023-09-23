package com.husseinblog.blog.controllers;

import com.husseinblog.blog.models.Comment;
import com.husseinblog.blog.models.CommentAddRequest;
import com.husseinblog.blog.models.CommentDeleteRequest;
import com.husseinblog.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentAddRequest commentAddRequest){
        int userId = commentAddRequest.getUserId();
        int blogId = commentAddRequest.getBlogId();
        String commentText = commentAddRequest.getCommentText();
        return ResponseEntity.ok(commentService.addComment(userId,blogId,commentText));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestBody CommentDeleteRequest commentDeleteRequest) throws Exception {
        int commentId = commentDeleteRequest.getCommentId();
        int userId = commentDeleteRequest.getUserId();

        return ResponseEntity.ok(commentService.deleteComment(commentId,userId));
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comment>> getByBlogId(@PathVariable int blogId){
        return ResponseEntity.ok(commentService.findByBlog(blogId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getByUserId(@PathVariable int userId){
        return ResponseEntity.ok(commentService.findAllByUser(userId));
    }
}
