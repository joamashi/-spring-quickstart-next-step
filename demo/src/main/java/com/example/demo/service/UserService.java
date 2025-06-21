// 📄 src/main/java/com/example/demo/service/UserService.java

package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 전체 사용자 조회
    public List<User> getAllUsers() {
        return userMapper.getUserList();
    }

    // 사용자 등록
    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    // 이메일로 사용자 한 명 조회 (로그인 등에 사용 가능)
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}
