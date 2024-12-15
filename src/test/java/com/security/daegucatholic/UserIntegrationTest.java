package com.security.daegucatholic;

import com.security.daegucatholic.model.User;
import com.security.daegucatholic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testCreateAndFindUser() {
        // 새 사용자 생성
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setEmail("testuser@example.com");

        userService.createUser(user);

        // 데이터베이스에서 모든 사용자 조회
        List<User> users = userService.getAllUsers();
        assertThat(users).isNotEmpty();

        // 새로 생성한 사용자 검증
        User testUser = users.stream()
                .filter(u -> u.getUsername().equals("testuser"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Test user not found"));
        assertThat(testUser.getUsername()).isEqualTo("testuser");
        assertThat(testUser.getEmail()).isEqualTo("testuser@example.com");
    }

    @Test
    void testDeleteUser() {
        // 기존 데이터에서 사용자 "jane_doe" 검색
        List<User> users = userService.getAllUsers();
        User userToDelete = users.stream()
                .filter(u -> u.getUsername().equals("jane_doe"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("User 'jane_doe' not found"));

        // 사용자 삭제
        userService.deleteUserById(userToDelete.getId());

        // 삭제 후 데이터 검증
        List<User> remainingUsers = userService.getAllUsers();
        assertThat(remainingUsers)
                .noneMatch(u -> u.getUsername().equals("jane_doe"));
    }
}