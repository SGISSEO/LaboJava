package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.Film;

public record FilmDTO(
        Long filmId,
        String title,
        String genre,
        String description
) {

    public static FilmDTO fromEntity(Film film){

        if( film == null )
            return null;

        return new FilmDTO(
                film.getFilmId(),
                film.getTitle(),
                film.getGenre(),
                film.getDescription()
        );
    }
}
