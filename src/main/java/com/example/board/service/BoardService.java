package com.example.board.service;

import com.example.board.dto.request.SaveBoardRequest;
import com.example.board.dto.response.SaveBoardResponse;
import org.springframework.transaction.annotation.Transactional;

public interface BoardService {


    @Transactional
    SaveBoardResponse save(SaveBoardRequest saveBoardRequest);
}
