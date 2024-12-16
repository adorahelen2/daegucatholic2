package com.security.daegucatholic;

import com.security.daegucatholic.model.User;
import com.security.daegucatholic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserInsertionTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsertThousandUsers() {
        int numberOfUsers = 100000;

        IntStream.rangeClosed(1, numberOfUsers).forEach(i -> {
            User user = new User();
            user.setUsername("Mybatis User" + i);
            user.setEmail("Mybatis" + i + "@easycerti.com");
            user.setPassword("password" + i); // 실제로는 암호화를 적용해야 함

            userService.createUser(user);
        });

        // 삽입된 사용자 수 확인
        assertThat(userService.getAllUsers().size()).isGreaterThanOrEqualTo(100000);
    }
}
