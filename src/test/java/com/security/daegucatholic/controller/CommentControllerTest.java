package com.security.daegucatholic.controller;

import com.security.daegucatholic.model.Comment;
import com.security.daegucatholic.service.CommentService;
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

@WebMvcTest(CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @Test
    void testGetCommentsByPostId() throws Exception {
        Mockito.when(commentService.getCommentsByPostId(1L)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/comments/post/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testCreateComment() throws Exception {
        Comment comment = new Comment();
        comment.setPostId(1L);
        comment.setUserId(1L);
        comment.setContent("This is a test comment.");

        mockMvc.perform(post("/api/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"postId\": 1, \"userId\": 1, \"content\": \"This is a test comment.\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Comment created successfully."));
    }
}