// 📄 src/main/java/com/example/demo/controller/UserController.java

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.response.ApiResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // [GET] /users → 사용자 목록 조회
    @GetMapping
    public ApiResponse<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.success(users, "전체 사용자 조회 성공");
    }

    // [POST] /users → 사용자 등록
    @PostMapping
    public ApiResponse<Void> addUser(@RequestBody User user) {
        userService.createUser(user);
        return ApiResponse.success(null, "사용자 등록 성공");
    }
}
