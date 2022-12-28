package com.example.blog.dto.response;

import com.example.blog.domain.User;
import com.example.blog.domain.UserRole;
import lombok.Data;

@Data
public class UpdateUserResponse {

    private Long userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String email;
    private UserRole role;

    public UpdateUserResponse(User savedUser) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }
}
