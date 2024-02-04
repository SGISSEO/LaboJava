package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
