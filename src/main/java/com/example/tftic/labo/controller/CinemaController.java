package com.example.tftic.labo.controller;


import com.example.tftic.labo.models.dtos.CinemaDTO;
import com.example.tftic.labo.models.entity.Cinema;
import com.example.tftic.labo.bll.services.service.CinemaService;
import com.example.tftic.labo.models.form.CinemaForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @GetMapping
    public ResponseEntity<List<CinemaDTO>> getAll() {
        return ResponseEntity.ok(
                cinemaService.getAll().stream()
                        .map( CinemaDTO::fromEntity )
                        .toList()
        );
    }


    @GetMapping("/{cinemaId}")
    public ResponseEntity<CinemaDTO> getById(@PathVariable Long cinemaId){
        return ResponseEntity.ok(
                CinemaDTO.fromEntity( cinemaService.getById(cinemaId) )
        );
    }

    @PostMapping
    public ResponseEntity<CinemaDTO> create(@RequestBody @Valid CinemaForm form){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        CinemaDTO.fromEntity( cinemaService.insert(form.toEntity()) )
                );
    }

    @PutMapping("/{cinemaId}")
    public ResponseEntity<CinemaDTO> update(@PathVariable Long cinemaId, @RequestBody @Valid CinemaForm form){
        return ResponseEntity.ok(
                CinemaDTO.fromEntity(cinemaService.update(cinemaId, form.toEntity()) )
        );
    }


    @DeleteMapping("/{cinemaId}")
    public ResponseEntity<?> delete(@PathVariable Long cinemaId) {
        cinemaService.delete(cinemaId);
        return ResponseEntity.ok().build();
    }
}
