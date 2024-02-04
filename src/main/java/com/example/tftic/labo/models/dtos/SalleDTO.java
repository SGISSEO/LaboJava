package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.Salle;

public record SalleDTO(
        Long salleId,

        String name,

        int capacity
) {

    public static SalleDTO fromEntity(Salle salle){

        if( salle == null )
            return null;

        return new SalleDTO(
                salle.getSalleId(),
                salle.getName(),
                salle.getCapacity()
        );
    }
}
