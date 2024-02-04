package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.Cinema;

public record CinemaDTO(
        Long cinemaId,
        String name,
        String location,
        String address
) {

    public static CinemaDTO fromEntity(Cinema cinema){

        if( cinema == null )
            return null;

        return new CinemaDTO(
                cinema.getCinemaId(),
                cinema.getName(),
                cinema.getLocation(),
                cinema.getAddress()
        );
    }
}
