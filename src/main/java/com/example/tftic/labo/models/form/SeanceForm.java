package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.Seance;

import java.time.LocalDateTime;

public class SeanceForm {

    Long seanceId;
    LocalDateTime startTime;


    public Seance toEntity() {
        Seance seance = new Seance();
        seance.setSeanceId( seanceId );
        seance.setStartTime( startTime );
        return seance;
    }
}
