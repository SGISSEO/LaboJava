package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Reservation;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements CrudService<Reservation, Long>{

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }


    @Override
    public Reservation insert(Reservation reservation)  {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id)  {
        reservationRepository.deleteById(id);
    }
}
