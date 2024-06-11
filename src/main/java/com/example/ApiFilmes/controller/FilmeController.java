package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import com.example.ApiFilmes.service.AtualizarFilmeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filme")
@AllArgsConstructor
public class FilmeController {

  private final FilmeRepository filmeRepository;
  private final AtualizarFilmeService atualizarFilmeService;


  @GetMapping
  public ResponseEntity<List<Filme>> findAll() {
    return ResponseEntity.ok(filmeRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(filmeRepository.findById(id).orElseThrow(EntityNotFoundException::new));
  }

  @PostMapping
  public ResponseEntity<Filme> insert(@RequestBody Filme filme) {
    return ResponseEntity.ok(filmeRepository.save(filme));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Filme> update(@PathVariable Integer id, @RequestBody Filme filme) {
    return ResponseEntity.ok(atualizarFilmeService.exec(id, filme));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Filme> delete(@PathVariable Integer id) {
    if (filmeRepository.existsById(id)) {
      filmeRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    throw new EntityNotFoundException("Filme não encontrado!");
  }
}
