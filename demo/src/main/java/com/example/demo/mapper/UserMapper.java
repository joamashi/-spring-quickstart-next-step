// 📄 src/main/java/com/example/demo/mapper/UserMapper.java

package com.example.demo.mapper;

import com.example.demo.model.User;
import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    User getUserByEmail(String email);
    void insertUser(User user);
}
