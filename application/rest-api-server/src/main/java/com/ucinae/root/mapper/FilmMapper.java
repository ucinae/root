package com.ucinae.root.mapper;

import com.ucinae.root.dto.res.MovieDetailsRes;
import com.ucinae.root.model.Film;
import com.ucinae.root.dto.response.FilmResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    Film toFilm(MovieDetailsRes movieDetailsRes);

    FilmResponse toFilmResponse(Film film);
}
