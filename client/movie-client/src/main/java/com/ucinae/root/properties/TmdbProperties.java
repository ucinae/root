package com.ucinae.root.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("tmdb")
public class TmdbProperties {

    private String apiKey;

    private String bearerToken;

    private String tmdbBaseUrl = "https://api.themoviedb.org";
}
