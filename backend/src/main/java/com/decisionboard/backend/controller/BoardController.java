package com.decisionboard.backend.controller;

import com.decisionboard.backend.dto.BoardResponse;
import com.decisionboard.backend.dto.CreateBoardRequest;
import com.decisionboard.backend.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(
            @Valid @RequestBody CreateBoardRequest request
    ) {
        BoardResponse response = boardService.createBoard(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(
            @PathVariable UUID id
    ) {
        BoardResponse response = boardService.getBoard(id);

        return ResponseEntity.ok(response);
    }
}