package com.example.gutenberglibrary.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class GutenbergSearchResponse {

    private Integer count;
    private String next;
    private String previous;
    private List<GutenbergBookDto> results;
}