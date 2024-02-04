package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
