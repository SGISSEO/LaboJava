package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService implements CrudService<Salle, Long>{

    @Autowired
    private SalleRepository salleRepository;
    @Override
    public List<Salle> getAll() {
        return salleRepository.findAll();
    }

    @Override
    public Salle getById(Long id) {
        return salleRepository.findById(id).orElseThrow();
    }


    @Override
    public Salle insert(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public Salle update(Long id, Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public void delete(Long id) {
        salleRepository.deleteById(id);
    }
}
