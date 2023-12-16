package com.creation.kitchen.crud.service;

import com.creation.kitchen.crud.data.InMemoryPostRepository;
import com.creation.kitchen.crud.data.PostRepository;
import com.creation.kitchen.crud.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Mock
    PostRepository repository = mock(PostRepository.class);

    PostService service = new PostService(repository);

    @Test
    void getAllPosts() {
        List<Post> testPosts = new ArrayList<>();
        testPosts.add(new Post(0L, "testTitle", "testContent"));
        testPosts.add(new Post(1L, "testTitle", "testContent"));
        when(repository.getAllPosts()).thenReturn(testPosts);

        Assertions.assertThat(service.getAllPosts().size()).isEqualTo(2);
    }

    @Test
    void createPost() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        when(repository.createPost(post1)).thenReturn(post1);

        Assertions.assertThat(service.createPost(post1)).isEqualTo(post1);
    }

    @Test
    void createPostDuplicate() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        when(repository.getPostById(post1.getId())).thenReturn(Optional.of(post1));

        Exception e = assertThrows(IllegalArgumentException.class, () -> service.createPost(post1));
        Assertions.assertThat(e.getMessage()).isEqualTo("Duplicate Post!");
    }

    @Test
    void deletePost() {
        service.deletePost(0L);
        verify(repository).deletePostById(0L);
    }

    @Test
    void editPost() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        when(repository.editPost(post1.getId(), post1)).thenReturn(Optional.of(post1));

        Assertions.assertThat(service.editPost(0L, post1).get()).isEqualTo(post1);
    }
}