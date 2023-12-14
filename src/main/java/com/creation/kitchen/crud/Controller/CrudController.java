package com.creation.kitchen.crud.Controller;

import com.creation.kitchen.crud.domain.Post;
import com.creation.kitchen.crud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CrudController {

    private final PostService postService;

    @Autowired
    CrudController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    @ResponseBody
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("posts")
    @ResponseBody
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @DeleteMapping("posts")
    @ResponseBody
    public Post deletePost(@RequestParam Long id) { return postService.deletePost(id); }

    @PutMapping("posts")
    @ResponseBody
    public Post updatePost(@RequestParam Long id, @RequestBody Post updated) {
        return postService.editPost(id, updated);
    }
}
