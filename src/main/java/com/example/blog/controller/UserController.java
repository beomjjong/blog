package com.example.blog.controller;

import com.example.blog.dto.request.LoginUserRequest;
import com.example.blog.dto.request.SaveUserRequest;
import com.example.blog.dto.request.UpdateUserRequest;
import com.example.blog.dto.response.DeleteUserResponse;
import com.example.blog.dto.response.SaveUserResponse;
import com.example.blog.dto.response.UpdateUserResponse;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SaveUserResponse> save(@RequestBody @Valid SaveUserRequest saveUserRequest) {
       SaveUserResponse saveUserResponse = userService.save(saveUserRequest);
       return new ResponseEntity<>(saveUserResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{userNo}")
    public ResponseEntity<UpdateUserResponse> update(@PathVariable Long userNo,
                                                     @RequestBody UpdateUserRequest updateUserRequest) {
        UpdateUserResponse updateUserResponse = userService.update(userNo, updateUserRequest);
        return new ResponseEntity<>(updateUserResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userNo}")
    public ResponseEntity<DeleteUserResponse> delete(@PathVariable Long userNo) {
        DeleteUserResponse deleteUserResponse = userService.delete(userNo);
        return new ResponseEntity<>(deleteUserResponse, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SaveUserResponse>> getAll() {
        List<SaveUserResponse> users = userService.findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<SaveUserResponse> getUser(@PathVariable Long userNo) {
        SaveUserResponse saveUserResponse = userService.getUser(userNo);
        return new ResponseEntity<>(saveUserResponse, HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public String login(@RequestBody LoginUserRequest request) {
//        String resultMessage = userService.login(request.getUserId(), request.getPassword());
//        return resultMessage;
//    }


    @PostMapping("/login")
    public ResponseEntity<SaveUserResponse> login(@RequestBody SaveUserRequest saveUserRequest) {
        log.info("userId = {}, userPwd = {}", saveUserRequest.getUserId(), saveUserRequest.getUserPwd());
        if (userService.login(saveUserRequest.getUserId(), saveUserRequest.getUserPwd()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //TODO 지금 하던거 그대로 안보고 작성할 줄 알아야 하고, user CRUD 검즘로직 추가하기, (@Valid) => 비밀번호 표현식.
    //TODO 회원 비밀번호 암호화.
    //TODO 회원 조회 추가.

    //TODO 게시글 CRUD 작성자에 유저아이디 입력. -> 조회수 필드 추가 후 증가로직(새로고침 할 경우에 조회수가 증가되면 안된다.)

    // TODO 로그인 -> 세션 + 쿠키 로그인 (인터셉터, 아규먼트 리졸버, 필터) (접근 한 회원이 본인인지 확인하기 Ex.회원 수정 및 삭제 또는 게시글 삭제 및 수정은 본인만 할 수 있다.)
    // TODO 로그아웃 -> 세션 만료.
    // TODO 댓글기능.
    // TODO 페이징 조회, --> queryDsl

    // TODO 예외처리 --> exceptionHandler, controllerAdvice
    
    // TODO 여유가 되면 로그 수집까지 -> AOP or Filter

    // TODO JAVA, JPA, QueryDsl, AOP, Intercepter, ArgumentResolver, Session, Validation
    // spring -> 기본적으로 기초적으로 다룰 줄 알고 앞으로 공부할 방향이나 목적을 알 수 있다. //
}
