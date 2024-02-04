package com.example.tftic.labo.controller;

import com.example.tftic.labo.models.dtos.SalleDTO;
import com.example.tftic.labo.models.entity.Salle;
import com.example.tftic.labo.bll.services.service.SalleService;
import com.example.tftic.labo.models.form.SalleForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/salles")
public class SalleController {


    private final SalleService salleService;


    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public ResponseEntity<List<SalleDTO>> getAll() {
        return ResponseEntity.ok(
                salleService.getAll().stream()
                        .map( SalleDTO::fromEntity )
                        .toList()
        );
    }

    @GetMapping("/{salleId}")
    public ResponseEntity<SalleDTO> getById(@PathVariable Long salleId){
        return ResponseEntity.ok(
                SalleDTO.fromEntity( salleService.getById(salleId) )
        );
    }


    @PostMapping
    public ResponseEntity<SalleDTO> create(@RequestBody @Valid SalleForm form){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        SalleDTO.fromEntity( salleService.insert(form.toEntity()) )
                );
    }

    @PutMapping("/{salleId}")
    public ResponseEntity<SalleDTO> update(@PathVariable Long salleId, @RequestBody @Valid SalleForm form){
        return ResponseEntity.ok(
                SalleDTO.fromEntity(salleService.update(salleId, form.toEntity()) )
        );
    }



    @DeleteMapping("/{salleId}")
    public ResponseEntity<?> delete(@PathVariable Long salleId) {
        salleService.delete(salleId);
        return ResponseEntity.ok().build();
    }
}
