package com.example.blog.dto.response;

import com.example.blog.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginUserResponse {

    private Long userNo;
    private String userId;

    public LoginUserResponse(User user) {
        this.userNo = user.getUserNo();
        this.userId = user.getUserId();
    }
}
