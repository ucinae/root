package com.ucinae.root.client;

import com.ucinae.root.MovieClientTests;
import com.ucinae.root.movie.client.TmdbClient;
import com.ucinae.root.movie.dto.res.MovieDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.then;

@Slf4j
@SpringBootTest
class TmdbClientTest extends MovieClientTests {

    @Autowired
    private TmdbClient tmdbClient;

    @Test
    public void getDetailsTest() {
        // given
        Integer expectedMovieId = 475557;

        // when
        MovieDetailsResponse actualMovieDetailsResponse = tmdbClient.getMovieDetail(expectedMovieId);

        // then
        log.info("MovieDetail = {}", actualMovieDetailsResponse);
        then(actualMovieDetailsResponse.getId()).isEqualTo(expectedMovieId);
    }

}