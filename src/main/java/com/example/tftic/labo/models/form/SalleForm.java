package com.example.tftic.labo.models.form;

import com.example.tftic.labo.models.entity.Salle;

public class SalleForm {
    Long salleId;
    String name;
    int capacity;

    public Salle toEntity() {
        Salle salle = new Salle();
        salle.setSalleId( salleId );
        salle.setName( name );
        salle.setCapacity( capacity );
        return salle;
    }
}
