package com.example.blog.service;


import com.example.blog.dto.request.LoginUserRequest;
import com.example.blog.dto.request.SaveUserRequest;
import com.example.blog.dto.request.UpdateUserRequest;
import com.example.blog.dto.response.DeleteUserResponse;
import com.example.blog.dto.response.LoginUserResponse;
import com.example.blog.dto.response.SaveUserResponse;
import com.example.blog.dto.response.UpdateUserResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    SaveUserResponse save(SaveUserRequest saveUserRequest);

    @Transactional
    UpdateUserResponse update(Long userNo, UpdateUserRequest updateUserRequest);

    @Transactional
    DeleteUserResponse delete(Long userNo);

    List<SaveUserResponse> findUsers();

    SaveUserResponse getUser(Long userNo);

    LoginUserResponse login(LoginUserRequest loginUserRequest);
}

