package com.salshaikhi.task.service;

import com.salshaikhi.task.exception.NotFoundException;
import com.salshaikhi.task.model.Comment;
import com.salshaikhi.task.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> allComments(){
        return commentRepository.findAll();
    }

    public Comment commentById(Long id) {
        return commentRepository.findById(id).orElseThrow(()-> new NotFoundException("Comment is not found"));
    }
}
