package com.husseinblog.blog.services;

import com.husseinblog.blog.models.User;
import com.husseinblog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired UserService(UserRepository userRepository){this.userRepository=userRepository;}

    public String createAccount(String username, String password) throws NoSuchAlgorithmException {

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return "Please don't leave any fields empty!";
        }
        if (userRepository.existsByUsername(username)) {
            return "Username Taken!";
        }
        User user = new User();
        user.setUsername(username);
        user.setSalt(generateSalt());
        String hashedPassword = hash(password+user.getSalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "Account created!";
    }

    public String login(String username, String password) throws NoSuchAlgorithmException {
        if(!userRepository.existsByUsername(username)){
            return "No such username found!";
        }
        User user = userRepository.findByUsername(username);
        String hashedPassword = hashAndSaltPassword(password,user.getSalt());
        if(!user.getPassword().equals(hashedPassword)){
            return "Incorrect username or password";
        }
        return "Login success";
    }
    public String hash(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    private String generateSalt(){
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public String hashAndSaltPassword(String password, String salt)
            throws NoSuchAlgorithmException {
        return hash(password + salt);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
    public User getUserbyId(int userId){
        User user = userRepository.findByUserId(userId);
        return (user==null)?null:user;
    }
}
