package com.salshaikhi.task.service;

import com.salshaikhi.task.exception.NotFoundException;
import com.salshaikhi.task.model.Post;
import com.salshaikhi.task.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> allPosts(){
        return postRepository.findAll();
    }

    public Post postById(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new NotFoundException("Post is not found"));
    }
}
