package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filme")
@AllArgsConstructor
public class FilmeController {

    private final FilmeRepository filmeRepository;

    @GetMapping
    public ResponseEntity<List<Filme>> findAll(){
        return ResponseEntity.ok(filmeRepository.findAll());
    }
}
