package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.CinemaService;
import com.example.tftic.labo.models.entity.Cinema;
import com.example.tftic.labo.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl extends CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getById(Long cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow();
    }

    @Override
    public Cinema insert(Cinema cinema) {
        return cinemaRepository.save( cinema );
    }

    @Override
    public Cinema update(Long cinemaId, Cinema cinema) {
        Cinema toUpdate = getById( cinemaId );
        toUpdate.setAddress( cinema.getAddress() );
        toUpdate.setCinemaId( cinema.getCinemaId() );
        toUpdate.setLocation(  cinema.getLocation() );
        toUpdate.setName( cinema.getName() );
        return cinemaRepository.save( toUpdate );
    }

    @Override
    public void delete(Long cinemaId) {
        Cinema toDelete = getById( cinemaId );
        cinemaRepository.delete( toDelete );
    }
}
