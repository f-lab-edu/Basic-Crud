package com.creation.kitchen.crud.Controller;

import com.creation.kitchen.crud.domain.Post;
import com.creation.kitchen.crud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// TODO: create a Response wrapper class
@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("posts")
    public Post createPost(@RequestBody Post post) {
        // TODO: need to handle Exception
        return postService.createPost(post);
    }

    @DeleteMapping("posts")
    public void removePost(@RequestParam Long id) {
        postService.deletePost(id);
    }

    @PutMapping("posts")
    public Optional<Post> editPost(@RequestParam Long id, @RequestBody Post updated) {
        return postService.editPost(id, updated);
    }
}
