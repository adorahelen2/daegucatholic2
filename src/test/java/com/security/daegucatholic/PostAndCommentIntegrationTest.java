package com.security.daegucatholic;

import com.security.daegucatholic.model.Post;
import com.security.daegucatholic.model.Comment;
import com.security.daegucatholic.service.PostService;
import com.security.daegucatholic.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostAndCommentIntegrationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Test
    void testFindPosts() {
        // 데이터베이스에서 모든 게시글 조회
        List<Post> posts = postService.getAllPosts();

        // 기존 데이터 검증
        assertThat(posts).isNotEmpty();
        assertThat(posts.size()).isEqualTo(2); // 샘플 데이터에 두 개의 게시글이 있음

        Post firstPost = posts.stream()
                .filter(post -> post.getTitle().equals("First Post"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("First Post not found"));
        assertThat(firstPost.getContent()).isEqualTo("This is the content of the first post.");
    }

    @Test
    void testCreateAndDeletePost() {
        // 새 게시글 생성
        Post newPost = new Post();
        newPost.setUserId(1L);
        newPost.setTitle("New Post");
        newPost.setContent("This is a new post content.");
        postService.createPost(newPost);

        // 게시글 추가 확인
        List<Post> posts = postService.getAllPosts();
        assertThat(posts).anyMatch(post -> post.getTitle().equals("New Post"));

        // 게시글 삭제
        Post createdPost = posts.stream()
                .filter(post -> post.getTitle().equals("New Post"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New Post not found"));
        postService.deletePostById(createdPost.getId());

        // 삭제 확인
        posts = postService.getAllPosts();
        assertThat(posts).noneMatch(post -> post.getTitle().equals("New Post"));
    }

    @Test
    void testFindCommentsForPost() {
        // 특정 게시글에 대한 댓글 조회
        List<Comment> comments = commentService.getCommentsByPostId(1L);

        // 댓글 검증
        assertThat(comments).isNotEmpty();
        assertThat(comments.size()).isEqualTo(1); // 첫 번째 게시글에 댓글이 1개
        assertThat(comments.get(0).getContent()).isEqualTo("This is a comment by Jane on John's post.");
    }

    @Test
    void testCreateAndDeleteComment() {
        // 새 댓글 생성
        Comment newComment = new Comment();
        newComment.setPostId(2L);
        newComment.setUserId(2L);
        newComment.setContent("This is a new comment.");
        commentService.createComment(newComment);

        // 댓글 추가 확인
        List<Comment> comments = commentService.getCommentsByPostId(2L);
        assertThat(comments).anyMatch(comment -> comment.getContent().equals("This is a new comment."));

        // 댓글 삭제
        Comment createdComment = comments.stream()
                .filter(comment -> comment.getContent().equals("This is a new comment."))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New comment not found"));
        commentService.deleteCommentById(createdComment.getId());

        // 삭제 확인
        comments = commentService.getCommentsByPostId(2L);
        assertThat(comments).noneMatch(comment -> comment.getContent().equals("This is a new comment."));
    }
}