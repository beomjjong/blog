package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.dto.request.SaveBoardRequest;
import com.example.board.dto.response.SaveBoardResponse;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public SaveBoardResponse save(SaveBoardRequest saveBoardRequest) {
        Board board = Board.builder()
                .title(saveBoardRequest.getTitle())
                .content(saveBoardRequest.getContent())
                .count(saveBoardRequest.getCount())
                .user(saveBoardRequest.getUser())
                .build();
        Board savedBoard = boardRepository.save(board);

        SaveBoardResponse saveBoardResponse = new SaveBoardResponse(savedBoard);
        return saveBoardResponse;
    }
}
