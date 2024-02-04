package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.SeanceService;
import com.example.tftic.labo.models.entity.Seance;
import com.example.tftic.labo.repository.*;

import java.util.List;

public class SeanceServiceImpl extends SeanceService {

    private final SeanceRepository seanceRepository;
    private final UserRepository userRepository;
    private final SalleRepository salleRepository;
    private final ReservationRepository reservationRepository;
    private final FilmRepository filmRepository;
    private final CinemaRepository cinemaRepository;

    public SeanceServiceImpl(SeanceRepository seanceRepository, UserRepository userRepository, SalleRepository salleRepository, ReservationRepository reservationRepository, FilmRepository filmRepository, CinemaRepository cinemaRepository) {
        this.seanceRepository = seanceRepository;
        this.userRepository = userRepository;
        this.salleRepository = salleRepository;
        this.reservationRepository = reservationRepository;
        this.filmRepository = filmRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance getById(Long seanceId) {
        return seanceRepository.findById(seanceId).orElseThrow();
    }

    @Override
    public Seance insert(Seance seance) {
        return seanceRepository.save( seance );
    }

    @Override
    public Seance update(Long seanceId, Seance seance) {
        Seance toUpdate = getById( seanceId );
        toUpdate.setSeanceId( seance.getSeanceId() );
        toUpdate.setStartTime( seance.getStartTime() );
        return seanceRepository.save( toUpdate );
    }

    @Override
    public void delete(Long seanceId) {
        Seance toDelete = getById( seanceId );
        seanceRepository.delete( toDelete );
    }
}
