package com.example.tftic.labo.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "\"seance\"")
@Entity
@Getter @Setter
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "seance_id", nullable = false)
    private Long seanceId;

    @Column(name = "seance_startTime", nullable = false)
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "seance_filmId", nullable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "seance_salleId", nullable = false)
    private Salle salle;
}
