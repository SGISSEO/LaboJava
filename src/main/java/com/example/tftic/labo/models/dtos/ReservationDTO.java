package com.example.tftic.labo.models.dtos;

import com.example.tftic.labo.models.entity.Reservation;

import java.time.LocalDateTime;

public record ReservationDTO(

        Long reservationId,

        LocalDateTime reservationTime
) {

    public static ReservationDTO fromEntity(Reservation reservation){

        if( reservation == null )
            return null;

        return new ReservationDTO(
                reservation.getReservationId(),
                reservation.getReservationTime()
        );
    }
}
