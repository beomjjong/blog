package com.example.blog.controller;


import com.example.blog.dto.request.SaveBoardRequest;
import com.example.blog.dto.response.SaveBoardResponse;
import com.example.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<SaveBoardResponse> save(@RequestBody @Valid SaveBoardRequest saveBoardRequest) {
        SaveBoardResponse saveBoardResponse = boardService.save(saveBoardRequest);
        return new ResponseEntity<>(saveBoardResponse, HttpStatus.CREATED);
    }


}
