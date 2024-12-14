package com.security.daegucatholic.mapper;

import com.security.daegucatholic.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    // 게시글 삽입
    @Insert("INSERT INTO posts (user_id, title, content) VALUES (#{userId}, #{title}, #{content})")
    void insertPost(Post post);

    // 게시글 ID로 조회
    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findPostById(Long id);

    // 특정 유저의 게시글 조회
    @Select("SELECT * FROM posts WHERE user_id = #{userId}")
    List<Post> findPostsByUserId(Long userId);

    // 모든 게시글 조회
    @Select("SELECT * FROM posts")
    List<Post> findAllPosts();

    // 게시글 업데이트
    @Update("UPDATE posts SET title = #{title}, content = #{content}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void updatePost(Post post);

    // 게시글 삭제
    @Delete("DELETE FROM posts WHERE id = #{id}")
    void deletePostById(Long id);
}