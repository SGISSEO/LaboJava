package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.Reservation;

import java.time.LocalDateTime;

public class ReservationForm {
    Long reservationId;
    LocalDateTime reservationTime;

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setReservationId( reservationId );
        reservation.setReservationTime( reservationTime );
        return reservation;
    }
}
