package com.example.gutenberglibrary.service;

import com.example.gutenberglibrary.dto.GutenbergBookDto;
import com.example.gutenberglibrary.dto.GutenbergSearchResponse;
import com.example.gutenberglibrary.entity.Book;
import com.example.gutenberglibrary.exception.BookNotFoundException;
import com.example.gutenberglibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final GutenbergApiClient apiClient;


    @Transactional
    public List<Book> findByCategory(String category) {
        String term = requireNonBlank(category, "category");

        List<Book> cached = bookRepository.findBySubjectsContainingIgnoreCase(term);
        if (!cached.isEmpty()) {
            log.info("Category '{}' served from cache ({} books)", term, cached.size());
            return cached;
        }

        log.info("Category '{}' not cached, fetching from Gutenberg API", term);
        GutenbergSearchResponse response = apiClient.searchByCategory(term);
        List<Book> persisted = persistAll(response);

        List<Book> matches = persisted.stream()
                .filter(b -> b.getSubjects() != null
                        && b.getSubjects().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT)))
                .toList();

        if (matches.isEmpty()) {
            throw new BookNotFoundException("No books found for category: " + term);
        }
        return matches;
    }


    @Transactional
    public List<Book> findByAuthor(String authorName) {
        String term = requireNonBlank(authorName, "authorName");

        List<Book> cached = bookRepository.findByAuthorContainingIgnoreCase(term);
        if (!cached.isEmpty()) {
            log.info("Author '{}' served from cache ({} books)", term, cached.size());
            return cached;
        }

        log.info("Author '{}' not cached, fetching from Gutenberg API", term);
        GutenbergSearchResponse response = apiClient.searchByAuthor(term);
        List<Book> persisted = persistAll(response);

        // The API's "search" param is full-text (titles + authors), so filter
        // down to results that actually match the requested author.
        List<Book> matches = persisted.stream()
                .filter(b -> b.getAuthor() != null
                        && b.getAuthor().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT)))
                .toList();

        if (matches.isEmpty()) {
            throw new BookNotFoundException("No books found for author: " + term);
        }
        return matches;
    }

    /** Manual sync used by POST /api/books/sync?q= to seed/refresh the DB. */
    @Transactional
    public List<Book> syncFromQuery(String query) {
        String term = requireNonBlank(query, "q");
        GutenbergSearchResponse response = apiClient.search(term);
        List<Book> persisted = persistAll(response);
        if (persisted.isEmpty()) {
            throw new BookNotFoundException("Gutenberg API returned no results for: " + term);
        }
        return persisted;
    }

    @Transactional(readOnly = true)
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    private List<Book> persistAll(GutenbergSearchResponse response) {
        if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
            return List.of();
        }

        return response.getResults().stream()
                .map(this::upsert)
                .toList();
    }

    private Book upsert(GutenbergBookDto dto) {
        Book book = bookRepository.findByGutenbergId(dto.getId())
                .orElseGet(Book::new);

        book.setGutenbergId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.authorNamesJoined());
        book.setSubjects(dto.subjectsJoined());
        book.setDownloadCount(dto.getDownloadCount());
        book.setCoverImageUrl(dto.getCoverImageUrl());

        return bookRepository.save(book);
    }

    private String requireNonBlank(String value, String fieldName) {
        if (!StringUtils.hasText(value)) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value.trim();
    }
}
