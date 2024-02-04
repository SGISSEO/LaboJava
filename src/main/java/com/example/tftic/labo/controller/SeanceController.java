package com.example.tftic.labo.controller;

import com.example.tftic.labo.models.dtos.SeanceDTO;
import com.example.tftic.labo.models.form.SeanceForm;
import com.example.tftic.labo.bll.services.service.SeanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/seances")
public class SeanceController {


    private final SeanceService seanceService;


    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public ResponseEntity<List<SeanceDTO>> getAll() {
        List<SeanceDTO> seances = seanceService.getAll().stream()
                .map(SeanceDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(seances);
    }

    @GetMapping("/{seanceId}")
    public ResponseEntity<SeanceDTO> getSeanceById(@PathVariable Long seanceId) {

        SeanceDTO seance = SeanceDTO.fromEntity(seanceService.getById(seanceId));
        return ResponseEntity.ok(seance);
    }


    @PostMapping
    public ResponseEntity<SeanceDTO> create(
            @Valid @RequestBody SeanceForm form
            ){
        SeanceDTO dto = SeanceDTO.fromEntity(seanceService.insert(form.toEntity()));
        return ResponseEntity.status(201).body(dto);
    }
    @PutMapping("/{seanceId}")
    public ResponseEntity<SeanceDTO> updateSeance(
            @PathVariable Long seanceId,
            @Valid @RequestBody SeanceForm form
    ){
        SeanceDTO dto = SeanceDTO.fromEntity(seanceService.update(seanceId, form.toEntity()));
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


    @DeleteMapping("/{seanceId}")
    public ResponseEntity<Void> deleteSeance(
            @PathVariable Long seanceId
    ){
        seanceService.delete(seanceId);
        return ResponseEntity.status(200).build();
    }
}
