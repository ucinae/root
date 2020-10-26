package com.ucinae.root.dto.res;

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
    private String backdropPath;
    private MovieCollection belongsToCollection;
    private Long budget;
    private List<Genre> genres;
    private String homepage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private List<ProductionCompany> productionCompanies;
    private List<ProductionCountry> productionCountries;
    private LocalDateTime releaseDate;
    private Integer revenue;
    private Integer runtime;
    private List<Language> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;
}
