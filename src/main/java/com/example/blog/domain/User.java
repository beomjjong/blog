package com.example.blog.domain;


import com.example.board.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;



@NoArgsConstructor
@Getter

@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long userNo;


    @Column(name = "S_user_id", nullable = false, unique = true)
    private String userId;


    @Column(name = "S_user_name", nullable = false)
    private String userName;


    @Column(name = "S_user_pwd", nullable = false)
    private String userPwd;

    @Column(name = "S_email", nullable = false, unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "S_role", nullable = false)
    private UserRole role;


    @Builder
    public User(String userId, String userName, String userPwd, String email, UserRole role) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.email = email;
        this.role = role;
    }

    public void updateUser(String email, String userName, String userPwd) {
        this.userId = email;
        this.userName = userName;
        this.userPwd = userPwd;
    }

}
