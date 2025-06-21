// 📄 src/main/java/com/example/demo/response/ApiResponse.java

package com.example.demo.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private int code;
    private LocalDateTime timestamp;

    private ApiResponse(boolean success, T data, String message, int code) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, "요청 성공", 200);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, data, message, 200);
    }

    public static <T> ApiResponse<T> fail(String message, int code) {
        return new ApiResponse<>(false, null, message, code);
    }

    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public String getMessage() { return message; }
    public int getCode() { return code; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
