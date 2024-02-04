package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
