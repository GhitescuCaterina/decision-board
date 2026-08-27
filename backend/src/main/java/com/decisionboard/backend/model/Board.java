package com.decisionboard.backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus status;

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Option> options = new ArrayList<>();

    protected Board() {
    }

    public Board(String title) {
        this.title = title;
        this.createdAt = Instant.now();
        this.status = BoardStatus.OPEN;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public BoardStatus getStatus() {
        return status;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(String text) {
        options.add(new Option(text, this));
    }
}