package com.example.blog.service;

import com.example.blog.dto.request.SaveBoardRequest;
import com.example.blog.dto.response.SaveBoardResponse;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {


    @Transactional
    SaveBoardResponse save(SaveBoardRequest saveBoardRequest);
}
