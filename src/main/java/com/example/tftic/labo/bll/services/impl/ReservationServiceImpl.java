package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.ReservationService;
import com.example.tftic.labo.models.entity.Reservation;
import com.example.tftic.labo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl extends ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow();
    }

    @Override
    public Reservation insert(Reservation reservation) {
        return reservationRepository.save( reservation );
    }

    @Override
    public Reservation update(Long reservationId, Reservation reservation) {
        Reservation toUpdate = getById( reservationId );
        toUpdate.setReservationId( reservation.getReservationId() );
        toUpdate.setReservationTime( reservation.getReservationTime() );
        return reservationRepository.save( toUpdate );
    }

    @Override
    public void delete(Long reservationId) {
        Reservation toDelete = getById( reservationId );
        reservationRepository.delete( toDelete );
    }
}
