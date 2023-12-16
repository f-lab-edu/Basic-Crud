package com.creation.kitchen.crud.data;

import com.creation.kitchen.crud.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPostRepositoryTest {

    InMemoryPostRepository repository = new InMemoryPostRepository();

    @AfterEach
    void afterEach() {
        repository.clearPosts();
    }

    @Test
    void getPostById() {
        Post post = new Post(0L, "testTitle", "testContent");
        repository.createPost(post);
        Assertions.assertThat(repository.getPostById(post.getId()).get()).isEqualTo(post);
    }

    @Test
    void getPostByIdNullCase() {
        Assertions.assertThat(repository.getPostById(1L).isPresent()).isEqualTo(false);
    }

    @Test
    void getAllPosts() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        Post post2 = new Post(1L, "testTitle", "testContent");

        repository.createPost(post1);
        repository.createPost(post2);

        Assertions.assertThat(repository.getAllPosts().size()).isEqualTo(2);
    }

    @Test
    void createPost() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        Assertions.assertThat(repository.createPost(post1)).isEqualTo(post1);
    }

    @Test
    void deletePostById() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        Post post2 = new Post(1L, "testTitle", "testContent");

        repository.createPost(post1);
        repository.createPost(post2);

        Assertions.assertThat(repository.getAllPosts().size()).isEqualTo(2);

        repository.deletePostById(0L);
        Assertions.assertThat(repository.getAllPosts().size()).isEqualTo(1);
    }

    @Test
    void editPost() {
        Post post1 = new Post(0L, "testTitle", "testContent");
        repository.createPost(post1);
        repository.editPost(0L, new Post(0L, "editedTestTitle", "editedTestContent"));
        Assertions.assertThat(repository.getPostById(0L).get().getTitle()).isEqualTo("editedTestTitle");
        Assertions.assertThat(repository.getPostById(0L).get().getContent()).isEqualTo("editedTestContent");
    }
}