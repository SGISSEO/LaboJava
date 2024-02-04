package com.example.tftic.labo.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "\"cinema\"")
@Entity
@Getter @Setter
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cinema_id", nullable = false)
    private Long cinemaId;

    @Column(name = "cinema_name", nullable = false)
    private String name;

    @Column(name = "cinema_location", nullable = false)
    private String location;

    @Column(name = "cinema_address", nullable = false)
    private String address;
}
