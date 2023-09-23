package com.husseinblog.blog.controllers;

import com.husseinblog.blog.models.Industry;
import com.husseinblog.blog.services.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/industry")
@CrossOrigin(origins = "*")
public class IndustryController {
    @Autowired
    private IndustryService industryService;

    @GetMapping("/all")
    public ResponseEntity<List<Industry>> fetchAll(){
        return ResponseEntity.ok(industryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Industry> fetchById(@PathVariable int id){
        try {
            System.out.println("Got request for: " +id);
            return ResponseEntity.ok(industryService.findById(id));
        }catch (Exception e){
            System.out.println("Got request for:" +id );
            System.out.println("ERROR");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Industry());
        }
    }
}
