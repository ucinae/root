package com.ucinae.root.service;

import com.ucinae.root.client.TmdbClient;
import com.ucinae.root.dto.res.MovieDetailsRes;
import com.ucinae.root.mapper.FilmMapper;
import com.ucinae.root.model.Film;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final TmdbClient tmdbClient;
    private final FilmMapper filmMapper;

    public Film getFilm(String filmId) {

        MovieDetailsRes movieDetail = tmdbClient.getMovieDetail(NumberUtils.toInt(filmId));

        return filmMapper.toFilm(movieDetail);
    }
}
