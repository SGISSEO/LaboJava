package com.example.tftic.labo.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Table(name = "\"reservation\"")
@Entity
@Getter @Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @Column(name = "reservation_reservationTime", nullable = false)
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
}
