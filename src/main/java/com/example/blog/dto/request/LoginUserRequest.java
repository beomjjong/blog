package com.example.blog.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginUserRequest {

    private String userId;
    private String password;
}
