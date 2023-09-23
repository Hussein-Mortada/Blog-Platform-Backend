package com.husseinblog.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "comment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

//    @Column(name = "blogId", nullable = false)
//    private int blogId;
//
//    @Column(name = "userId", nullable = false)
//    private int userId;

    @Column(name = "commenttext", nullable = false)
    private String commenttext;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Transient
    private String username;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    @JsonIgnore
    private Blog blog;

    public String getUsername() {
        return user != null ? user.getUsername() : null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getBlogId() {
        return blog.getBlogId();
    }

    public void setBlogId(int blogId) {
        this.blog.setBlogId(blogId);// = blogId;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public void setUserId(int userId) {
        this.user.setUserId(userId);// = userId;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commenttext='" + commenttext + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user.getUserId() +
//                ", blog=" + blog +
                '}';
    }
}
