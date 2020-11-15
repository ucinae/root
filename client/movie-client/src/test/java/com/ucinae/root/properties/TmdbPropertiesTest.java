package com.ucinae.root.properties;

import com.ucinae.root.MovieClientTests;
import com.ucinae.root.movie.properties.TmdbProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class TmdbPropertiesTest extends MovieClientTests {

    @Autowired
    private TmdbProperties tmdbProperties;

    @Test
    public void getTmdbPropertiesTest() {
        log.info("TMDB API KEY = {}", tmdbProperties.getApiKey());
        log.info("TMDB Bearer Token = {}", tmdbProperties.getBearerToken());
        log.info("TMDB Base URL = {}", tmdbProperties.getTmdbBaseUrl());
    }

}