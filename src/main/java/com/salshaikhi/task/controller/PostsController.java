package com.salshaikhi.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    @GetMapping("/posts")
    public ResponseEntity<String> allPosts(){
        return ResponseEntity.ok("Posts");
    }
}
