package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.Film;

public class FilmForm {
    Long filmId;
    String title;
    String genre;
    String description;

    public Film toEntity() {
        Film film = new Film();
        film.setFilmId( filmId );
        film.setTitle( title );
        film.setGenre( genre );
        film.setDescription( description );
        return film;
    }
}
