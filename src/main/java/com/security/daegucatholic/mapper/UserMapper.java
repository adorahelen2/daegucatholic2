package com.security.daegucatholic.mapper;

import com.security.daegucatholic.model.User;
import org.apache.ibatis.annotations.*;

        import java.util.List;

@Mapper
public interface UserMapper {

    // 유저 삽입
    @Insert("INSERT INTO users (username, password, email) VALUES (#{username}, #{password}, #{email})")
    void insertUser(User user);

    // 유저 ID로 조회
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findUserById(Long id);

    // 모든 유저 조회
    @Select("SELECT * FROM users")
    List<User> findAllUsers();

    // 유저 삭제
    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUserById(Long id);
}