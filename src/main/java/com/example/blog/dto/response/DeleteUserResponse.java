package com.example.blog.dto.response;

import com.example.blog.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteUserResponse {

    private String deleteUserName;

    public DeleteUserResponse(User deletedUser) {
        this.deleteUserName = deleteUserName;
    }
}
