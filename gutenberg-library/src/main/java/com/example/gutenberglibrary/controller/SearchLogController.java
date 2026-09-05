package com.example.gutenberglibrary.controller;

import com.example.gutenberglibrary.dto.SearchLogResponse;
import com.example.gutenberglibrary.service.SearchLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search-logs")
@RequiredArgsConstructor
public class SearchLogController {

    private final SearchLogService searchLogService;

    @GetMapping
    public ResponseEntity<Page<SearchLogResponse>> getAll(
            @PageableDefault(size = 20, sort = "timestamp", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(searchLogService.findAll(pageable).map(SearchLogResponse::from));
    }

    @GetMapping("/user/{requestedBy}")
    public ResponseEntity<List<SearchLogResponse>> getByUser(@PathVariable String requestedBy) {
        List<SearchLogResponse> logs = searchLogService.findByRequestedBy(requestedBy).stream()
                .map(SearchLogResponse::from)
                .toList();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/failed")
    public ResponseEntity<List<SearchLogResponse>> getFailed() {
        List<SearchLogResponse> logs = searchLogService.findFailed().stream()
                .map(SearchLogResponse::from)
                .toList();
        return ResponseEntity.ok(logs);
    }
}