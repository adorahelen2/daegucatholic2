package com.security.daegucatholic.service;

import com.security.daegucatholic.mapper.UserMapper;
import com.security.daegucatholic.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    // 유저 생성
    public void createUser(User user) {
        // 비밀번호 암호화 등의 추가 로직을 여기에 구현할 수 있음
        userMapper.insertUser(user);
    }

    // ID로 유저 조회
    public User getUserById(Long id) {
        return userMapper.findUserById(id);
    }

    // 모든 유저 조회
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    // 유저 삭제
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }
}