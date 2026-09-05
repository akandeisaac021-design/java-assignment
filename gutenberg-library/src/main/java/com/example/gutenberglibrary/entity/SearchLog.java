package com.example.gutenberglibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name = "search_logs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SearchType searchType;

    @Column(nullable = false, length = 300)
    private String searchTerm;

    @Column(nullable = false, length = 200)
    private String requestedBy;

    @Column(nullable = false)
    private boolean resultFound;

    private Integer resultCount;

    @Column(nullable = false)
    private Instant timestamp;

    @PrePersist
    private void onCreate() {
        this.timestamp = Instant.now();
    }
}