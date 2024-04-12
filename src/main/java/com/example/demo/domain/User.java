package com.example.demo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String name;
    private String password;
    private String nickname;

}
