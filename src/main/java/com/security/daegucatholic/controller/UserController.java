//package com.security.daegucatholic.controller;
//
//import com.security.daegucatholic.model.User;
//import com.security.daegucatholic.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    // 유저 생성
//    @PostMapping
//    public ResponseEntity<String> createUser(@RequestBody User user) {
//        userService.createUser(user);
//        return ResponseEntity.ok("User created successfully.");
//    }
//
//    // ID로 유저 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    // 모든 유저 조회
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    // 유저 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
//        userService.deleteUserById(id);
//        return ResponseEntity.ok("User deleted successfully.");
//    }
//}