package com.husseinblog.blog.services;

import com.husseinblog.blog.models.Blog;
import com.husseinblog.blog.models.Comment;
import com.husseinblog.blog.models.User;
import com.husseinblog.blog.repositories.BlogRepository;
import com.husseinblog.blog.repositories.CommentRepository;
import com.husseinblog.blog.repositories.CommentRepositoryCrud;
import com.husseinblog.blog.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final CommentRepositoryCrud commentRepositoryCrud;

    @Autowired
    CommentService(CommentRepository commentRepository,BlogRepository blogRepository,UserRepository userRepository,CommentRepositoryCrud commentRepositoryCrud){
        this.commentRepository=commentRepository;
        this.blogRepository=blogRepository;
        this.userRepository=userRepository;
        this.commentRepositoryCrud = commentRepositoryCrud;
    }


    public String addComment(int userId, int blogId, String commentText){
        Comment comment = new Comment();
        User user  = userRepository.findByUserId(userId);
        comment.setUser(user);
        Optional<Blog> blog = blogRepository.findById(blogId);
        comment.setBlog(blog.get());
        if(commentText == null || commentText.equals("")){
            return "Comment text cannot be empty!";
        }
        comment.setCommenttext(commentText);
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
        return "Comment Added!";
    }
    @Transactional
    public String deleteComment(int commentId, int userId) throws Exception {
        try {
            Optional<Comment> comment = commentRepository.findById(commentId);
            if(!comment.isPresent() || comment.isEmpty()){
                return "No such comment found";
            }
            if(comment.get().getUser().getUserId()!=userId){
                return "Cannot delete comment that is not yours";
            }
            System.out.println("comment ID" + commentId);
            System.out.println(comment.get());
            commentRepositoryCrud.deleteCommentById(commentId);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error deleting comment");
        }
        return "Comment Deleted";
    }
    public List<Comment> findByBlog(int blogId){
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(!blog.isPresent()){
            return new ArrayList<>();
        }
        return commentRepository.findAllByBlog(blog.get());
    }
    public List<Comment> findAllByUser(int userId){
        User user = userRepository.findByUserId(userId);
        return commentRepository.findAllByUser(user);
    }

}
