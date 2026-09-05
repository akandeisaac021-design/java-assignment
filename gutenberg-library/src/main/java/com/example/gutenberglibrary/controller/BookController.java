package com.example.gutenberglibrary.controller;

import com.example.gutenberglibrary.dto.BookResponse;
import com.example.gutenberglibrary.entity.Book;
import com.example.gutenberglibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookResponse>> getByCategory(
            @PathVariable String category,
            @RequestParam String requestedBy) {
        List<Book> books = bookService.findByCategory(category, requestedBy);
        return ResponseEntity.ok(toResponses(books));
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<BookResponse>> getByAuthor(
            @PathVariable String authorName,
            @RequestParam String requestedBy) {
        List<Book> books = bookService.findByAuthor(authorName, requestedBy);
        return ResponseEntity.ok(toResponses(books));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        return ResponseEntity.ok(bookService.getAllCategories());
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
