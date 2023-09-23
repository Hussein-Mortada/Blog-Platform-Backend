//package com.husseinblog.blog;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("*") // Specify the URL(s) you want to allow CORS for.
//                .allowedOrigins("*") // Change this to restrict to specific origins if needed.
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods.
//                .allowedHeaders("*"); // Specify the allowed headers.
//    }
//}
