package com.example.demo.dto.response;

import com.example.demo.domain.User;

public record SignInResponse(
        Long id, String nickname
) {
//    public User toEntity() {
//        return User.builder()
//                .id(id)
//                .nickname(nickname)
//                .build();
//    }
}
