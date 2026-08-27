package com.decisionboard.backend.controller;

import com.decisionboard.backend.dto.CreateBoardRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @PostMapping
    public CreateBoardRequest createBoard(
            @Valid @RequestBody CreateBoardRequest request
    ) {
        return request;
    }
}