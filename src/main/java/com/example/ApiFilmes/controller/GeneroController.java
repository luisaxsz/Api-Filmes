package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.model.Genero;
import com.example.ApiFilmes.repository.GeneroRepository;
import com.example.ApiFilmes.service.AtualizarGeneroService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
@AllArgsConstructor
public class GeneroController {

  private final GeneroRepository generoRepository;
  private final AtualizarGeneroService atualizarGeneroService;


  @GetMapping
  public ResponseEntity<List<Genero>> findAll() {
    return ResponseEntity.ok(generoRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Genero> findById(@PathVariable Long id) {
    return ResponseEntity.ok(generoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Genero não encontrado")));
  }

  @PostMapping
  public ResponseEntity<Genero> insert(@RequestBody Genero genero) {
    return ResponseEntity.ok(generoRepository.save(genero));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Genero> update(@PathVariable Long id, @RequestBody Genero genero) {
    return ResponseEntity.ok(atualizarGeneroService.update(id, genero));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Genero> delete(@PathVariable Long id) {
    if (generoRepository.existsById(id)) {
      generoRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}
