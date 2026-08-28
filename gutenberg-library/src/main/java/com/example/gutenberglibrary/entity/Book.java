package com.example.gutenberglibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(name = "uk_books_gutenberg_id", columnNames = "gutenberg_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gutenberg_id", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private Long gutenbergId;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(length = 300)
    private String author;

    @Column(length = 2000)
    private String subjects;

    @Column(name = "download_count")
    private Long downloadCount;

    @Column(name = "cover_image_url", length = 1000)
    private String coverImageUrl;

    @Column(name = "last_synced_at")
    private Instant lastSyncedAt;

    @PrePersist
    @PreUpdate
    private void touch() {
        this.lastSyncedAt = Instant.now();
    }
}
