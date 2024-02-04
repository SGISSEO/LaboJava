package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Film;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmService implements CrudService<Film, Long>{


    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getById(Long id) {
        return filmRepository.findById(id).orElseThrow();
    }



    @Override
    public Film insert(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film update(Long id, Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void delete(Long id)  {
        filmRepository.deleteById(id);
    }
}
