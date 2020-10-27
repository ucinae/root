package com.ucinae.root.client;

import com.ucinae.root.dto.res.MovieDetailsRes;
import com.ucinae.root.properties.TmdbProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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

    @Getter
    @AllArgsConstructor
    private enum PATH {
        GET_DETAILS("/3/movie/")
        ;

        private final String api;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tmdbProperties.getBearerToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    public MovieDetailsRes getMovieDetail(Integer movieId) {

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(tmdbProperties.getTmdbBaseUrl() + PATH.GET_DETAILS.getApi() + movieId))
                .accept(MediaType.APPLICATION_JSON)
                .headers(getHeaders())
                .build();

        return restTemplate.exchange(requestEntity, MovieDetailsRes.class).getBody();
    }
}
