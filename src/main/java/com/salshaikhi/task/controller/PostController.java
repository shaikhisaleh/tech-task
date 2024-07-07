package com.salshaikhi.task.controller;

import com.salshaikhi.task.model.Post;
import com.salshaikhi.task.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> allPosts(){
        return ResponseEntity.ok(postService.allPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> postById(@PathVariable Long id){
        return ResponseEntity.ok(postService.postById(id));
    }
}
