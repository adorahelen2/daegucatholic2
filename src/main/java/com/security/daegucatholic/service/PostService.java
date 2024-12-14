package com.security.daegucatholic.service;

import com.security.daegucatholic.mapper.PostMapper;
import com.security.daegucatholic.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    // 게시글 생성
    public void createPost(Post post) {
        postMapper.insertPost(post);
    }

    // ID로 게시글 조회
    public Post getPostById(Long id) {
        return postMapper.findPostById(id);
    }

    // 특정 유저의 게시글 조회
    public List<Post> getPostsByUserId(Long userId) {
        return postMapper.findPostsByUserId(userId);
    }

    // 모든 게시글 조회
    public List<Post> getAllPosts() {
        return postMapper.findAllPosts();
    }

    // 게시글 업데이트
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    // 게시글 삭제
    public void deletePostById(Long id) {
        postMapper.deletePostById(id);
    }
}