package com.husseinblog.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "blog_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "blogtext", nullable = false)
    private String blogtext;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "industry_id")
    private Industry industry;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;

    public int getIndustryId(){
        return this.industry.getIndustryId();
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogtext() {
        return blogtext;
    }

    public void setBlogtext(String blogtext) {
        this.blogtext = blogtext;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", blogtext='" + blogtext + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                ", industry=" + industry +
                ", comments=" + comments +
                '}';
    }
}