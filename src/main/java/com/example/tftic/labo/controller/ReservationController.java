package com.example.tftic.labo.controller;

import com.example.tftic.labo.models.dtos.ReservationDTO;
import com.example.tftic.labo.models.entity.Reservation;
import com.example.tftic.labo.bll.services.service.ReservationService;
import com.example.tftic.labo.models.form.ReservationForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {


    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAll() {
        return ResponseEntity.ok(
                reservationService.getAll().stream()
                        .map( ReservationDTO::fromEntity )
                        .toList()
        );
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getById(@PathVariable Long reservationId){
        return ResponseEntity.ok(
                ReservationDTO.fromEntity( reservationService.getById(reservationId) )
        );
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody @Valid ReservationForm form){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ReservationDTO.fromEntity( reservationService.insert(form.toEntity()) )
                );
    }


    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> update(@PathVariable Long reservationId, @RequestBody @Valid ReservationForm form){
        return ResponseEntity.ok(
                ReservationDTO.fromEntity(reservationService.update(reservationId, form.toEntity()) )
        );
    }




    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> delete(@PathVariable Long reservationId) {
        reservationService.delete(reservationId);
        return ResponseEntity.ok().build();
    }
}
