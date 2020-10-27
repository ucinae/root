package com.ucinae.root.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ucinae.root.model.Genre;
import com.ucinae.root.model.Language;
import com.ucinae.root.model.MovieCollection;
import com.ucinae.root.model.ProductionCompany;
import com.ucinae.root.model.ProductionCountry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailsRes {
    private Boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("belongs_to_collection")
    private MovieCollection belongsToCollection;
    private Long budget;
    private List<Genre> genres;
    private String homepage;
    private Integer id;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private List<ProductionCompany> productionCompanies;
    @JsonProperty("production_countries")
    private List<ProductionCountry> productionCountries;
    @JsonProperty("release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime releaseDate;
    private Integer revenue;
    private Integer runtime;
    @JsonProperty("spoken_languages")
    private List<Language> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;
}
