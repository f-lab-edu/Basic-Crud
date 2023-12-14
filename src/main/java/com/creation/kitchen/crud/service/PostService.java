package com.creation.kitchen.crud.service;

import com.creation.kitchen.crud.data.PostRepository;
import com.creation.kitchen.crud.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public Post createPost(Post post) {
        return postRepository.createPost(post);
    }

    public Post deletePost(Long id) {
        return postRepository.deletePostById(id);
    }

    public Post editPost(Long id, Post updated) {
        return postRepository.editPost(id, updated);
    }
}
