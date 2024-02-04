package com.example.tftic.labo.bll.services.impl;

import com.example.tftic.labo.bll.services.service.SalleService;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalleServiceImpl extends SalleService {


    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public List<Salle> getAll() {
        return salleRepository.findAll();
    }

    @Override
    public Salle getById(Long salleId) {
        return salleRepository.findById(salleId).orElse(null);
    }

    @Override
    public Salle insert(Salle salle) {
        return salleRepository.save( salle );
    }

    @Override
    public Salle update(Long salleId, Salle salle) {
        Salle toUpdate = getById( salleId );
        toUpdate.setSalleId( salle.getSalleId() );
        toUpdate.setName( salle.getName() );
        toUpdate.setCapacity( salle.getCapacity() );
        return salleRepository.save( toUpdate );
    }


    @Override
    public void delete(Long salleId) {
        Salle toDelete = getById( salleId );
        salleRepository.delete( toDelete );
    }
}
