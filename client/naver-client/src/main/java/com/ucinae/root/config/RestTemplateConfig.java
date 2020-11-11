package com.ucinae.root.config;

import com.ucinae.root.properties.NaverApiProperties;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(NaverApiProperties.class)
public class RestTemplateConfig {
    private final NaverApiProperties naverApiProperties;
    private static final String CLIENT_ID = "X-Naver-Client-Id";
    private static final String CLIENT_SECRET = "X-Naver-Client-Secret";

    @Bean
    public RestTemplate restTemplate() {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        HttpClient client = HttpClientBuilder.create()
                .setMaxConnTotal(50)
                .setMaxConnPerRoute(20)
                .build();

        factory.setHttpClient(client);
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(5000);

        return new RestTemplateBuilder()
                .requestFactory(() -> factory)
                .rootUri(naverApiProperties.getBaseUri())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(CLIENT_ID, naverApiProperties.getClientId())
                .defaultHeader(CLIENT_SECRET, naverApiProperties.getClientSecret())
                .build();
    }
}
