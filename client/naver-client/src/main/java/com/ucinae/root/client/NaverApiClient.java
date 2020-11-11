package com.ucinae.root.client;

import com.ucinae.root.dto.req.NaverBlogRequest;
import com.ucinae.root.dto.res.NaverBlogResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverApiClient {
    private final RestTemplate restTemplate;

    @Getter
    @AllArgsConstructor
    private enum API {
        SEARCH_BLOG("/v1/search/blog")
        ;

        private final String path;
    }

    public NaverBlogResponse getNaverBlog(NaverBlogRequest naverBlogRequest) {

        ResponseEntity<NaverBlogResponse> result = restTemplate.exchange(
                naverBlogRequest.toUriString(API.SEARCH_BLOG.path),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                NaverBlogResponse.class
        );

        // TODO error handler
        if (result.getStatusCode().is4xxClientError()) {
            log.info("HTTP 400");
            return null;
        } else if (result.getStatusCode().is5xxServerError()) {
            log.info("HTTP 500");
            return null;
        }

        return result.getBody();
    }
}
