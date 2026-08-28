package com.example.gutenberglibrary.service;

import com.example.gutenberglibrary.dto.GutenbergSearchResponse;
import com.example.gutenberglibrary.exception.ExternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;


@Slf4j
@Service
public class GutenbergApiClient {

    private final RestClient restClient;

    public GutenbergApiClient(RestClient gutenbergRestClient) {
        this.restClient = gutenbergRestClient;
    }

    private static final String BOOKS_PATH = "/api/books";

    public GutenbergSearchResponse searchByCategory(String category) {
        return get(category);
    }

    public GutenbergSearchResponse searchByAuthor(String authorName) {
        return get(authorName);
    }

    public GutenbergSearchResponse search(String query) {
        return get(query);
    }

    private GutenbergSearchResponse get(String q) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(BOOKS_PATH)
                            .queryParam("q", q)
                            .queryParam("page_size", 20)
                            .build())
                    .retrieve()
                    .body(GutenbergSearchResponse.class);
        } catch (RestClientResponseException ex) {
            log.warn("Gutenberg API returned {} for q={}", ex.getStatusCode(), q);
            throw new ExternalApiException(
                    "Gutenberg API responded with status " + ex.getStatusCode().value(), ex);
        } catch (RestClientException ex) {
            log.warn("Gutenberg API unreachable for q={}: {}", q, ex.getMessage());
            throw new ExternalApiException("Could not reach the Gutenberg API", ex);
        }
    }
}
