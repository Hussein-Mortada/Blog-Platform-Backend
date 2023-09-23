package com.husseinblog.blog.models;

public class CommentAddRequest {
    private String commentText;
    private int userId;
    private int blogId;

    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}
