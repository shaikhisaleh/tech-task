package com.salshaikhi.task.controller;

import com.salshaikhi.task.model.Comment;
import com.salshaikhi.task.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> allComments(){
        return ResponseEntity.ok(commentService.allComments());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> commentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.commentById(id));
    }
}
