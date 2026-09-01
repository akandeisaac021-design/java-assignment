package com.example.gutenberglibrary.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "gutenberg.api")
public class GutenbergApiProperties {

    private String baseUrl;

    private String host;

    private String key;
}
