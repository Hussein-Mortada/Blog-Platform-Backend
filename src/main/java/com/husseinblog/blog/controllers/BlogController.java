package com.husseinblog.blog.controllers;

import com.husseinblog.blog.models.Blog;
import com.husseinblog.blog.models.BlogAddRequest;
import com.husseinblog.blog.models.BlogDeleteRequest;
import com.husseinblog.blog.models.BlogUpdateRequest;
import com.husseinblog.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> fetch5Blogs(){
        return ResponseEntity.ok(blogService.find5());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Blog>> fetchAllByUserId(@PathVariable int userId){
        return ResponseEntity.ok(blogService.findAllByUser(userId));
    }

    @GetMapping("/industry/{industryId}")
    public ResponseEntity<List<Blog>> fetchAllByIndustryId(@PathVariable int industryId){
        return ResponseEntity.ok(blogService.findAllByIndustry(industryId));
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> fetchByBlogId(@PathVariable int blogId){
        return ResponseEntity.ok(blogService.fetchById(blogId));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBlog(@RequestBody BlogAddRequest blogAddRequest) throws Exception {
        int userId = blogAddRequest.getUserId();
        String title = blogAddRequest.getTitle();
        String blogText = blogAddRequest.getBlogText();
        int industryId = blogAddRequest.getIndustryId();
        String message = blogService.addBlog(userId,title,blogText,industryId);
        if(message.equals("Blog added!")){
            return ResponseEntity.ok(message);
        }else{
            return ResponseEntity.status(500).body(message);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteBlog(@RequestBody BlogDeleteRequest blogDeleteRequest) throws Exception {
        int blogId=blogDeleteRequest.getBlogId();
        int userId=blogDeleteRequest.getUserId();
        System.out.println("Got request: blogid: " + blogId + " User Id: " + userId);
        String message = blogService.deleteBlog(blogId,userId);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBlog(@RequestBody BlogUpdateRequest blogUpdateRequest){
        int blogId=blogUpdateRequest.getBlogId();
        int userId=blogUpdateRequest.getUserId();
        String title = blogUpdateRequest.getTitle();
        String blogText = blogUpdateRequest.getBlogText();
        int industryId = blogUpdateRequest.getIndustryId();
        return ResponseEntity.ok(blogService.updateBlog(blogId,userId,title,blogText,industryId));
    }



}
