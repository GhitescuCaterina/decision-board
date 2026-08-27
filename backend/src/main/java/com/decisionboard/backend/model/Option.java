package com.decisionboard.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "board_options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private int votes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    protected Option() {
    }

    public Option(String text, Board board) {
        this.text = text;
        this.board = board;
        this.votes = 0;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getVotes() {
        return votes;
    }
}