package com.ucinae.root.mapper;

import com.ucinae.root.movie.dto.res.MovieDetailsResponse;
import com.ucinae.root.model.Film;
import com.ucinae.root.dto.response.FilmResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    Film toFilm(MovieDetailsResponse movieDetailsResponse);

    FilmResponse toFilmResponse(Film film);
}
