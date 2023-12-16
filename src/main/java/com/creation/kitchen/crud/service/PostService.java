package com.creation.kitchen.crud.service;

import com.creation.kitchen.crud.data.PostRepository;
import com.creation.kitchen.crud.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        validateDuplicate(post);
        return postRepository.createPost(post);
    }

    public void deletePost(Long id) {
        postRepository.deletePostById(id);
    }

    public Optional<Post> editPost(Long id, Post updated) {
        return postRepository.editPost(id, updated);
    }

    private void validateDuplicate(Post post) {
        postRepository.getPostById(post.getId())
                .ifPresent(p -> {
                    throw new IllegalArgumentException("Duplicate Post!");
                });
    }
}
