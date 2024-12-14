package com.security.daegucatholic.service;

import com.security.daegucatholic.mapper.CommentMapper;
import com.security.daegucatholic.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    // 댓글 생성
    public void createComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    // ID로 댓글 조회
    public Comment getCommentById(Long id) {
        return commentMapper.findCommentById(id);
    }

    // 특정 게시글의 댓글 조회
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentMapper.findCommentsByPostId(postId);
    }

    // 특정 유저의 댓글 조회
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentMapper.findCommentsByUserId(userId);
    }

    // 댓글 삭제
    public void deleteCommentById(Long id) {
        commentMapper.deleteCommentById(id);
    }
}