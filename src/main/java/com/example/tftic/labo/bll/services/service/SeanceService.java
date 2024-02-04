package com.example.tftic.labo.bll.services.service;

import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.models.entity.Seance;
import com.example.tftic.labo.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService implements CrudService<Seance, Long>{


    @Autowired
    private SeanceRepository seanceRepository;

    @Override
    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance getById(Long id){
        return seanceRepository.findById(id).orElseThrow();
    }


    @Override
    public Seance insert(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public Seance update(Long id, Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public void delete(Long id) {
        seanceRepository.deleteById(id);
    }
}
