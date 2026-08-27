package com.decisionboard.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateBoardRequest(

        @NotBlank(message = "Title cannot be empty")
        String title,

        @Size(min = 2, message = "At least two options are required")
        List<@NotBlank(message = "Option cannot be empty") String> options

) {
}