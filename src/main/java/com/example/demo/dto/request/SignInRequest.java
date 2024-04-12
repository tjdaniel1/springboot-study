package com.example.demo.dto.request;

import com.example.demo.domain.User;

public record SignInRequest(String username, String password) {
    public User toEntity() {
        return User.builder()
                .name(username)
                .nickname(password)
                .build();
    }
}
