package com.ucinae.root.client;

import com.ucinae.root.dto.res.MovieDetailsRes;
import com.ucinae.root.properties.TmdbProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class TmdbClient {
    private final TmdbProperties tmdbProperties;
    private final RestTemplate restTemplate;

    private static final String TMDB_BASE_URL = "https://api.themoviedb.org";

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tmdbProperties.getBearerToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    public MovieDetailsRes getMovieDetail(Integer movieId) {

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(TMDB_BASE_URL))
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaders())
                .build();

        return restTemplate.exchange(requestEntity, MovieDetailsRes.class).getBody();
    }
}
