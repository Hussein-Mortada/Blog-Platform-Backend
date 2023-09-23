package com.husseinblog.blog.models;
import jakarta.validation.constraints.NotBlank;

public class BlogAddRequest {

    @NotBlank(message = "User ID is required!")
    private int userId;
    @NotBlank(message = "Title is required!")
    private String title;
    @NotBlank(message = "Text is required!")
    private String blogText;
    @NotBlank(message = "Industry is required!")
    private int industryId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }
}
