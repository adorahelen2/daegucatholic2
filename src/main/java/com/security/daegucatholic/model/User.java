package com.security.daegucatholic.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;            // 유저 ID
    private String username;    // 사용자 이름
    private String password;    // 암호
    private String email;       // 이메일
    private LocalDateTime createdAt; // 계정 생성 날짜
}