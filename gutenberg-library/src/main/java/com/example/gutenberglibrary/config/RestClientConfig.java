package com.example.gutenberglibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

public class RestClientConfig {

    @Bean
    public RestClient gutenbergRestClient(GutenbergApiProperties properties) {


        RestClient.Builder builder = RestClient.builder()
                .baseUrl(properties.getBaseUrl());

        if (StringUtils.hasText(properties.getKey())) {
            builder.defaultHeader("X-RapidAPI-Key", properties.getKey());
        }
        if (StringUtils.hasText(properties.getHost())) {
            builder.defaultHeader("X-RapidAPI-Host", properties.getHost());
        }
        builder.defaultHeader(HttpHeaders.ACCEPT, "application/json");

        return builder.build();


    }
}
