package com.salshaikhi.task.service;

import com.salshaikhi.task.model.Comment;
import com.salshaikhi.task.model.Post;
import com.salshaikhi.task.repository.CommentRepository;
import com.salshaikhi.task.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FetchDataService {
    private final PostRepository postRepository;

    private final CommentRepository commentRepository;
    private final RestTemplate restTemplate;

    public FetchDataService(PostRepository postRepository, CommentRepository commentRepository, RestTemplate restTemplate) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.restTemplate = restTemplate;
    }

    public String fetchAndSaveData() {
        String postsUrl = "https://jsonplaceholder.typicode.com/users/1/posts";
        Post[] posts = restTemplate.getForObject(postsUrl, Post[].class);
        System.out.println("Posts length  " +posts.length);
        if(posts == null || posts.length < 1){
            return "No posts found";
        }
        //Save posts
        postRepository.saveAll(Arrays.asList(posts));

        //Fetch comments
        for (Post post : posts) {
            String commentsUrl = "https://jsonplaceholder.typicode.com/posts/" + post.getId() + "/comments";
            Comment[] comments = restTemplate.getForObject(commentsUrl, Comment[].class);
            if (comments != null) {
                List<Comment> commentList = Arrays.asList(comments);
                //link comments to their posts
                commentList.forEach(comment -> comment.setPost(post));
                commentRepository.saveAll(commentList);
            }
        }
        return "Data fetched successfully";
    }
}
