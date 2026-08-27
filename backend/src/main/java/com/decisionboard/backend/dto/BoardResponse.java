package com.decisionboard.backend.dto;

import com.decisionboard.backend.model.BoardStatus;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record BoardResponse(
        UUID id,
        String title,
        Instant createdAt,
        BoardStatus status,
        List<OptionResponse> options
) {
}