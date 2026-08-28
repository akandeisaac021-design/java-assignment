package com.example.gutenberglibrary.repository;

import com.example.gutenberglibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByGutenbergId(Long gutenbergId);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findBySubjectsContainingIgnoreCase(String subject);

    Page<Book> findAll(Pageable pageable);
}
