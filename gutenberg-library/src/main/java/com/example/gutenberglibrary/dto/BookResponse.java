package com.example.gutenberglibrary.dto;

import com.example.gutenberglibrary.entity.Book;


public record BookResponse(
        Long id,
        Long gutenbergId,
        String title,
        String author,
        String subjects,
        Long downloadCount,
        String coverImageUrl
) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getGutenbergId(),
                book.getTitle(),
                book.getAuthor(),
                book.getSubjects(),
                book.getDownloadCount(),
                book.getCoverImageUrl()
        );
    }
}
