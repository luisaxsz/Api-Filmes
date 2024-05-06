package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import com.example.ApiFilmes.service.FilmeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filme")
@AllArgsConstructor
public class FilmeController {

    private final FilmeRepository filmeRepository;
    private final FilmeService filmeService;


    @GetMapping
    public ResponseEntity<List<Filme>> findAll() {
        return ResponseEntity.ok(filmeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id) {
        return ResponseEntity.ok(filmeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado")));
    }

    @PostMapping
    public ResponseEntity<Filme> insert(@RequestBody Filme filme) {
        return ResponseEntity.ok(filmeRepository.save(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme) {
        return ResponseEntity.ok(filmeService.update(id, filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> delete(@PathVariable Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
