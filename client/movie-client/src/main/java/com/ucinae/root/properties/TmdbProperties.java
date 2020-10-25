package com.ucinae.root.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("tmdb")
@EnableConfigurationProperties(TmdbProperties.class)
public class TmdbProperties {

    private String apiKey;
}
