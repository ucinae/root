package com.ucinae.root.service;

import com.ucinae.root.model.Film;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Test
    public void getFilmTest() {
        Film film = filmService.getFilm(76341);

        log.info("film result = {}", film);
    }

}