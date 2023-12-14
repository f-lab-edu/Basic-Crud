package com.creation.kitchen.crud.data;

import com.creation.kitchen.crud.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();

    Post createPost(Post post);

    Post deletePostById(Long id);

    Post editPost(Long id, Post updated);
}
