package com.husseinblog.blog.controllers;

import com.husseinblog.blog.models.User;
import com.husseinblog.blog.models.UserRegisterLoginRequest;
import com.husseinblog.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterLoginRequest request) throws NoSuchAlgorithmException {
        String username = request.getUsername();
        String password = request.getPassword();
        String message = userService.createAccount(username,password);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserbyId(userId));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRegisterLoginRequest request) throws NoSuchAlgorithmException {
        String username = request.getUsername();
        String password = request.getPassword();

        String message = userService.login(username,password);
        System.out.println(username + " " + password + " " + message);
        if(message.equals("Incorrect username or password") || message.equals("No such username found!")){
            return ResponseEntity.ok("Login Failed!  Incorrect username or password");
        }
        else{
            User user = userService.getUser(username);
            String token = Jwts.builder()
                    .claim("userId", user.getUserId())
                    .claim("username", user.getUsername())
                    .signWith(SignatureAlgorithm.HS256, "SuperSecretJWTKey123SuperSecretJWTKey123SuperSecretJWTKey123")
                    .compact();
            return ResponseEntity.ok(token);
        }
    }
}
