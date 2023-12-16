package com.creation.kitchen.crud.data;

import com.creation.kitchen.crud.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Optional<Post> getPostById(Long id);

    List<Post> getAllPosts();

    Post createPost(Post post);

    void deletePostById(Long id);

    Optional<Post> editPost(Long id, Post updated);
}
