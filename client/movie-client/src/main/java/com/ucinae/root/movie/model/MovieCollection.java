package com.ucinae.root.movie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieCollection {
    private Long id;
    private String name;
    private String posterPath;
    private String backdropPath;
}
