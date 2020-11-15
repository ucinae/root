package com.ucinae.root.service;

import com.ucinae.root.mapper.FilmMapper;
import com.ucinae.root.model.Film;
import com.ucinae.root.movie.client.TmdbClient;
import com.ucinae.root.movie.dto.res.MovieDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final TmdbClient tmdbClient;
    private final FilmMapper filmMapper;

    public Film getFilm(Integer filmId) {

        MovieDetailsResponse movieDetail = tmdbClient.getMovieDetail(filmId);

        return filmMapper.toFilm(movieDetail);
    }
}
