package com.creation.kitchen.crud.data;

import com.creation.kitchen.crud.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryPostRepository implements PostRepository {

    private Map<Long, Post> posts = new HashMap<>();

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
    public Post deletePostById(Long id) {
        Post post = posts.get(id);
        posts.remove(id);
        return post;
    }

    @Override
    public Post editPost(Long id, Post updated) {
        Post target = posts.get(id);
        if (target == null) {
            return null;
        }
        target.setContent(updated.getContent());
        target.setTitle(updated.getTitle());
        return target;
    }
}
