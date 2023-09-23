package com.husseinblog.blog.services;

import com.husseinblog.blog.models.Blog;
import com.husseinblog.blog.models.Industry;
import com.husseinblog.blog.models.User;
import com.husseinblog.blog.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final IndustryRepository industryRepository;
    private final CommentRepository commentRepository;

    private final BlogRepositoryCrud blogRepositoryCrud;

    @Autowired
    BlogService(BlogRepository blogRepository,UserRepository userRepository,IndustryRepository industryRepository,CommentRepository commentRepository,BlogRepositoryCrud blogRepositoryCrud ){
        this.blogRepository=blogRepository;
        this.userRepository=userRepository;
        this.industryRepository=industryRepository;
        this.commentRepository=commentRepository;
        this.blogRepositoryCrud = blogRepositoryCrud;
    }

    public List<Blog> find5(){
        ArrayList<Blog> blogs = (ArrayList<Blog>) blogRepository.findAll();
        ArrayList<Blog> blog10 = new ArrayList<>();
        for(int i = 0;i<5;i++){
            blog10.add(blogs.get(blogs.size()-1-i));
        }
        return blog10;
    }

    public List<Blog> findAllByUser(int userId){
        User user = userRepository.findByUserId(userId);
        return blogRepository.findAllByUser(user);
    }
    public List<Blog> findAllByIndustry(int industryId){
        Optional<Industry> industry = industryRepository.findById(industryId);
        return blogRepository.findAllByIndustry(industry.get()); //
    }

    public String addBlog(int userId,String title, String blogText, int industryId) throws Exception {

        if (title == null || title.isEmpty() || blogText == null || blogText.isEmpty()) {
            throw new IllegalArgumentException("Title and blog text are required.");
        }

        User user = userRepository.findByUserId(userId);
        if(user==null){
            throw new Exception("User ID not found");
        }
        try{
            Blog blog = new Blog();
            User user1 = userRepository.findByUserId(userId);
            blog.setUser(user1);
            //blog.setUserId(userId);
            blog.setTitle(title);
            blog.setBlogtext(blogText);
            Optional<Industry> industry = industryRepository.findById(industryId);
            blog.setIndustry(industry.get());
            //blog.setIndustryId(industryId);
            blog.setCreatedAt(new Date());
            blog.setUpdatedAt(new Date());
            blogRepository.save(blog);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error adding blog");
        }
        return "Blog added!";
    }
    @Transactional
    public String deleteBlog(int blogId, int userId) throws Exception {
        try{
            Optional<Blog> blog = blogRepository.findById(blogId);
            if(!blog.isPresent()){
                return "No such blog";
            }
            Blog blog1 = blog.get();
            if(blog1.getUser().getUserId()!=userId){
                return "Cannot delete blog that is not yours";
            }
            blogRepositoryCrud.deleteCommentsByBlogId(blogId);
            blogRepositoryCrud.deleteBlogById(blogId);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error deleting blog");
        }
        return "Blog deleted";
    }
    public Blog fetchById(int blogId){
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(!blog.isPresent()){
            return new Blog();
        }
        else{
            return blog.get();
        }
    }

    public String updateBlog(int blogId, int userId, String title, String blogtext, int industryId){
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(!blog.isPresent()){
            return "No such blog";
        }
        Blog blog1 = blog.get();
        if(blog1.getUser().getUserId()!=userId){
            return "Cannot update blog that is not yours";
        }
            Blog existingBlog = blog.get();
            existingBlog.setTitle(title);
            existingBlog.setBlogtext(blogtext);
            Optional<Industry> industry = industryRepository.findById(industryId);
            existingBlog.setIndustry(industry.get());
            existingBlog.setUpdatedAt(new Date());
            blogRepository.save(existingBlog);
            return "Blog updated";
    }
}
