package com.example.tftic.labo.controller;

import com.example.tftic.labo.models.dtos.FilmDTO;
import com.example.tftic.labo.models.entity.Film;
import com.example.tftic.labo.bll.services.service.FilmService;
import com.example.tftic.labo.models.form.FilmForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/films")
public class FilmController {


    private final FilmService filmService;


    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll() {
        return ResponseEntity.ok(
                filmService.getAll().stream()
                        .map( FilmDTO::fromEntity )
                        .toList()
        );
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmDTO> getById(@PathVariable Long filmId) {
        return ResponseEntity.ok(
                FilmDTO.fromEntity( filmService.getById(filmId) )
        );
    }

    @PostMapping
    public ResponseEntity<FilmDTO> create(@RequestBody @Valid FilmForm form){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        FilmDTO.fromEntity( filmService.insert(form.toEntity()) )
                );
    }

    @PutMapping("/{filmId}")
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable Long filmId, @RequestBody @Valid FilmForm form){
        return ResponseEntity.ok(
                FilmDTO.fromEntity(filmService.update(filmId, form.toEntity()) )
        );
    }


    @DeleteMapping("/{filmId}")
    public ResponseEntity<?> delete(@PathVariable Long filmId) {
        filmService.delete(filmId);
        return ResponseEntity.ok().build();
    }
}


