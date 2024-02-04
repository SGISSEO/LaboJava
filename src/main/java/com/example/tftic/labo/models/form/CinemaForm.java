package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.Cinema;

public class CinemaForm {
    Long cinemaId;
    String name;
    String location;
    String address;

    public Cinema toEntity(){
        Cinema cinema = new Cinema();
        cinema.setCinemaId( cinemaId );
        cinema.setName( name );
        cinema.setLocation( location );
        cinema.setAddress( address );
        return cinema;
    }
}
