package com.example.board.dto.response;

import com.example.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class SaveBoardResponse {
    private Long id;
    private String title;
    private String content;
    private int count;


    public SaveBoardResponse(Board savedBoard) {
        this.id = savedBoard.getId();
        this.title = savedBoard.getTitle();
        this.content = savedBoard.getContent();
        this.count = savedBoard.getCount();
    }
}
