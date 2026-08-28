package com.example.gutenberglibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GutenbergBookDto {


    private Long id;
    private String title;
    private List<AuthorDto> authors;
    private List<String> subjects;


    @JsonProperty("download_count")
    private Long downloadCount;

    @JsonProperty("cover_image")
    private String coverImageUrl;

    public String authorNamesJoined() {
        if (authors == null || authors.isEmpty()) {
            return "Unknown";
        }
        return authors.stream()
                .map(AuthorDto::getName)
                .filter(n -> n != null && !n.isBlank())
                .reduce((a, b) -> a + ", " + b)
                .orElse("Unknown");
    }

    public String subjectsJoined() {
        if (subjects == null || subjects.isEmpty()) {
            return null;
        }
        return String.join(", ", subjects);
    }

}
