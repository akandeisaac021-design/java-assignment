package com.example.gutenberglibrary.service;

import com.example.gutenberglibrary.entity.SearchLog;
import com.example.gutenberglibrary.entity.SearchType;
import com.example.gutenberglibrary.repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLogService {

    private final SearchLogRepository searchLogRepository;

    @Transactional
    public void record(SearchType searchType, String searchTerm, String requestedBy, int resultCount) {
        SearchLog entry = new SearchLog();
        entry.setSearchType(searchType);
        entry.setSearchTerm(searchTerm);
        entry.setRequestedBy(requestedBy);
        entry.setResultCount(resultCount);
        entry.setResultFound(resultCount > 0);
        searchLogRepository.save(entry);
    }

    @Transactional(readOnly = true)
    public Page<SearchLog> findAll(Pageable pageable) {
        return searchLogRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<SearchLog> findByRequestedBy(String requestedBy) {
        return searchLogRepository.findByRequestedByIgnoreCaseOrderByTimestampDesc(requestedBy);
    }

    @Transactional(readOnly = true)
    public List<SearchLog> findFailed() {
        return searchLogRepository.findByResultFoundFalseOrderByTimestampDesc();
    }
}