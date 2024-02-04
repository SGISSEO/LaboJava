package com.example.tftic.labo.repository;

import com.example.tftic.labo.models.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
