package com.decisionboard.backend.dto;

public record OptionResponse(
        Long id,
        String text,
        int votes
) {
}