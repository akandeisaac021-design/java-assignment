package com.example.gutenberglibrary.repository;

import com.example.gutenberglibrary.entity.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {

    List<SearchLog> findByRequestedByIgnoreCaseOrderByTimestampDesc(String requestedBy);

    List<SearchLog> findByResultFoundFalseOrderByTimestampDesc();
}