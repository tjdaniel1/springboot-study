package com.example.demo.dto.request;


import com.example.demo.domain.User;
import lombok.RequiredArgsConstructor;


public record UserRequest(String name, String password, String nickname) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
