package com.husseinblog.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "industry")
public class Industry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "industry_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int industryId;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "industry",cascade = CascadeType.ALL)
    private List<Blog> blogs;


    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "industryId=" + industryId +
                ", name='" + name + '\'' +
//                ", blogs=" + blogs +
                '}';
    }
}
