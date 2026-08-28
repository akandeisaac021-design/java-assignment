package com.example.gutenberglibrary.controller;

import com.example.gutenberglibrary.dto.BookResponse;
import com.example.gutenberglibrary.entity.Book;
import com.example.gutenberglibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookResponse>> getByCategory(String category) {
        List<Book> books = bookService.findByCategory(category);
        return ResponseEntity.ok(toResponses(books));
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<BookResponse>> getByAuthor(String authorName) {
        List<Book> books = bookService.findByAuthor(authorName);
        return ResponseEntity.ok(toResponses(books));
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookService.findAll(pageable).map(BookResponse::from));
    }

    @PostMapping("/sync")
    public ResponseEntity<List<BookResponse>> sync(String query) {
        List<Book> books = bookService.syncFromQuery(query);
        return ResponseEntity.status(201).body(toResponses(books));
    }

    private List<BookResponse> toResponses(List<Book> books) {
        return books.stream().map(BookResponse::from).toList();
    }
}
