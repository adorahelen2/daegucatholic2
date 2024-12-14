package com.security.daegucatholic.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;            // 댓글 ID
    private Long postId;        // 게시글 ID (posts 테이블의 외래 키)
    private Long userId;        // 댓글 작성자 ID (users 테이블의 외래 키)
    private String content;     // 댓글 내용
    private LocalDateTime createdAt; // 댓글 작성 시간
}