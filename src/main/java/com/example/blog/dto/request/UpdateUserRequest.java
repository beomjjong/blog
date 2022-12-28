package com.example.blog.dto.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpdateUserRequest {
    private String userName;
    private String userPwd;
    private String email;
}
