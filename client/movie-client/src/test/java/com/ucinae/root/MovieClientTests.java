package com.ucinae.root;

import com.ucinae.root.movie.properties.TmdbProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

public class MovieClientTests {
    @EnableConfigurationProperties(TmdbProperties.class)
    @SpringBootApplication
    static class TestConfiguration {

    }
}
