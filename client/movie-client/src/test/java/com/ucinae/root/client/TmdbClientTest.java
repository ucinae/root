package com.ucinae.root.client;

import com.ucinae.root.MovieClientTests;
import com.ucinae.root.dto.res.MovieDetailsRes;
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
        MovieDetailsRes actualMovieDetailsRes = tmdbClient.getMovieDetail(expectedMovieId);

        // then
        log.info("MovieDetail = {}", actualMovieDetailsRes);
        then(actualMovieDetailsRes.getId()).isEqualTo(expectedMovieId);
    }

}