package com.ucinae.root.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TmdbClient {
    private final RestTemplate restTemplate;


}
