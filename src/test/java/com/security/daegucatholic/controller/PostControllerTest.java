package com.security.daegucatholic.controller;

import com.security.daegucatholic.model.Post;
import com.security.daegucatholic.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    void testGetAllPosts() throws Exception {
        Mockito.when(postService.getAllPosts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testCreatePost() throws Exception {
        Post post = new Post();
        post.setUserId(1L);
        post.setTitle("Test Post");
        post.setContent("This is a test post.");

        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\": 1, \"title\": \"Test Post\", \"content\": \"This is a test post.\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Post created successfully."));
    }
}