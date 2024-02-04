package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.Seance;

import java.time.LocalDateTime;

public record SeanceDTO(
        Long seanceId,

        LocalDateTime startTime
) {

    public static SeanceDTO fromEntity(Seance seance){

        if( seance == null )
            return null;

        return new SeanceDTO(
                seance.getSeanceId(),
                seance.getStartTime()
        );
    }
}
