package com.security.daegucatholic.mapper;

import com.security.daegucatholic.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 댓글 삽입
    @Insert("INSERT INTO comments (post_id, user_id, content) VALUES (#{postId}, #{userId}, #{content})")
    void insertComment(Comment comment);

    // 댓글 ID로 조회
    @Select("SELECT * FROM comments WHERE id = #{id}")
    Comment findCommentById(Long id);

    // 특정 게시글의 댓글 조회
    @Select("SELECT * FROM comments WHERE post_id = #{postId}")
    List<Comment> findCommentsByPostId(Long postId);

    // 특정 유저의 댓글 조회
    @Select("SELECT * FROM comments WHERE user_id = #{userId}")
    List<Comment> findCommentsByUserId(Long userId);

    // 댓글 삭제
    @Delete("DELETE FROM comments WHERE id = #{id}")
    void deleteCommentById(Long id);
}