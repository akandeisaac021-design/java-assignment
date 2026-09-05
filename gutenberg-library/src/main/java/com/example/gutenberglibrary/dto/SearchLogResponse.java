package com.example.gutenberglibrary.dto;

import com.example.gutenberglibrary.entity.SearchLog;
import com.example.gutenberglibrary.entity.SearchType;

import java.time.Instant;

public record SearchLogResponse(
        Long id,
        SearchType searchType,
        String searchTerm,
        String requestedBy,
        boolean resultFound,
        Integer resultCount,
        Instant timestamp
) {
    public static SearchLogResponse from(SearchLog log) {
        return new SearchLogResponse(
                log.getId(),
                log.getSearchType(),
                log.getSearchTerm(),
                log.getRequestedBy(),
                log.isResultFound(),
                log.getResultCount(),
                log.getTimestamp()
        );
    }
}