package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.FilmService;
import com.example.tftic.labo.models.entity.Film;
import com.example.tftic.labo.repository.FilmRepository;

import java.util.List;

public class FilmServiceImpl extends FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getById(Long filmId) {
        return filmRepository.findById(filmId).orElseThrow();
    }

    @Override
    public Film insert(Film film) {
        return filmRepository.save( film );
    }

    @Override
    public Film update(Long filmId, Film film) {
        Film toUpdate = getById( filmId );
        toUpdate.setDescription( film.getDescription() );
        toUpdate.setFilmId( film.getFilmId() );
        toUpdate.setGenre( film.getGenre() );
        toUpdate.setTitle( film.getTitle() );
        return filmRepository.save( toUpdate );
    }

    @Override
    public void delete(Long filmId) {
        Film toDelete = getById( filmId );
        filmRepository.delete( toDelete );
    }
}
