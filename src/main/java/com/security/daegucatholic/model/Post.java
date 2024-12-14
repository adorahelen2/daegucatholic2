package com.security.daegucatholic.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;            // 게시글 ID
    private Long userId;        // 작성자 ID (users 테이블의 외래 키)
    private String title;       // 게시글 제목
    private String content;     // 게시글 내용
    private LocalDateTime createdAt; // 작성 시간
    private LocalDateTime updatedAt; // 수정 시간
}