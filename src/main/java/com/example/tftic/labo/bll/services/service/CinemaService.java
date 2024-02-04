package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Cinema;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService implements CrudService<Cinema, Long>{

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getById(Long id) {
        return cinemaRepository.findById(id).orElseThrow();
    }



    @Override
    public Cinema insert(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema update(Long id, Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }
}
