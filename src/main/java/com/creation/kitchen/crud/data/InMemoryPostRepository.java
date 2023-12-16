package com.creation.kitchen.crud.data;

import com.creation.kitchen.crud.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPostRepository implements PostRepository {

    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    @Override
    public Optional<Post> getPostById(Long id) {
        return Optional.ofNullable(posts.get(id));
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post createPost(Post post) {
        posts.put(post.getId(), post);
        return post;
    }

    @Override
    public void deletePostById(Long id) {
        Optional.ofNullable(posts.get(id))
                .ifPresent(post -> {
                    posts.remove(id);
                });
    }

    @Override
    public Optional<Post> editPost(Long id, Post updated) {
        Optional<Post> post = Optional.ofNullable(posts.get(id));
        post.ifPresent(p -> {
                    p.setTitle(updated.getTitle());
                    p.setContent(updated.getContent());
                });
        return post;
    }
}
