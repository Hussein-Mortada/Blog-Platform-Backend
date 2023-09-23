package com.husseinblog.blog.models;

public class BlogDeleteRequest {
    private int blogId;
    private int userId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
