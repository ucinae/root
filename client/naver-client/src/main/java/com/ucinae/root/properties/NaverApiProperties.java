package com.ucinae.root.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("naver")
public class NaverApiProperties {

    private String baseUri;

    private String clientId;
    private String clientSecret;
}
