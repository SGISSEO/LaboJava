package com.example.tftic.labo.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "\"film\"")
@Entity
@Getter @Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "film_id", nullable = false)
    private Long filmId;

    @Column(name = "film_title", nullable = false)
    private String title;

    @Column(name = "film_genre", nullable = false)
    private String genre;

    @Column(name = "film_description", nullable = false)
    private String description;
}
