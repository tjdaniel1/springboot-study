package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.SignInResponse;
import com.example.demo.exception.ExistUsernameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;

    public void signUp(UserRequest req){
        //DB 에 있는 유저인지 찾고
        List<User> byUserName = userMapper.findByUserName(req.name());
        // 있으면 뭔가 처리
        if(!byUserName.isEmpty())throw new ExistUsernameException();
        // 없으면 insert
        userMapper.addUser(req.toEntity());

    }

    public SignInResponse signIn(SignInRequest req){
        List<User> findByName = userMapper.findByUserName(req.username());
        if(findByName.isEmpty()) throw new UserNotFoundException("Login Fail.");
        User user = findByName.get(0);
        if(!user.getPassword().equals(req.password())) throw new UserNotFoundException("Login Fail.");
        return new SignInResponse(user.getId(), user.getNickname());
    }
}
