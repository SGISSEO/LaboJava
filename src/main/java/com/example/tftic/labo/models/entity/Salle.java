package com.example.tftic.labo.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "\"salle\"")
@Entity
@Getter @Setter
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "salle_id", nullable = false)
    private Long salleId;

    @Column(name = "salle_name", nullable = false)
    private String name;

    @Column(name = "salle_capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "salle_cinemaId", nullable = false)
    private Cinema cinema;
}
