package com.decisionboard.backend.service;

import com.decisionboard.backend.dto.BoardResponse;
import com.decisionboard.backend.dto.CreateBoardRequest;
import com.decisionboard.backend.dto.OptionResponse;
import com.decisionboard.backend.model.Board;
import com.decisionboard.backend.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponse createBoard(CreateBoardRequest request) {
        Board board = new Board(request.title().trim());

        for (String option : request.options()) {
            board.addOption(option.trim());
        }

        Board savedBoard = boardRepository.save(board);

        return toResponse(savedBoard);
    }

    public BoardResponse getBoard(UUID id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Board not found"
                ));

        return toResponse(board);
    }

    private BoardResponse toResponse(Board board) {
        List<OptionResponse> options = board.getOptions()
                .stream()
                .map(option -> new OptionResponse(
                        option.getId(),
                        option.getText(),
                        option.getVotes()
                ))
                .toList();

        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getCreatedAt(),
                board.getStatus(),
                options
        );
    }
}