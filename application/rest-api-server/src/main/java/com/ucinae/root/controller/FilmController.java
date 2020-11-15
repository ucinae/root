package com.ucinae.root.controller;

import com.ucinae.root.dto.request.FilmRequest;
import com.ucinae.root.dto.response.ApiResponse;
import com.ucinae.root.dto.response.FilmResponse;
import com.ucinae.root.error.ErrorCode;
import com.ucinae.root.error.exception.CustomException;
import com.ucinae.root.mapper.FilmMapper;
import com.ucinae.root.model.Film;
import com.ucinae.root.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/" + FilmController.API_VERSION)
@RequiredArgsConstructor
public class FilmController {
    public static final String API_VERSION = "v1";

    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @GetMapping("/films/{filmId}")
    public ResponseEntity<ApiResponse<FilmResponse>> getFilm(@PathVariable String filmId) {
        ApiResponse<FilmResponse> response = ApiResponse.<FilmResponse>builder()
                .apiVersion(API_VERSION)
                .method("FilmController#getFilm")
                .id(UUID.randomUUID().toString())
                .params(filmId)
                .build();

        Film film;

        try {
            film = filmService.getFilm(Integer.valueOf(filmId));
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), ErrorCode.INVALID_INPUT_VALUE, response);
        }

        response.setData(filmMapper.toFilmResponse(film));

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping("/films")
    public ResponseEntity<FilmResponse> createFilm(@Validated @RequestBody FilmRequest filmRequest) {
        return ResponseEntity.ok().body(FilmResponse.builder()
                .build());
    }
}
