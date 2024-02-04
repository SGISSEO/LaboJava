package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}

