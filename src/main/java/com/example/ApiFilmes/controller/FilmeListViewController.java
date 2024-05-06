package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.vw.FilmesListView;
import com.example.ApiFilmes.repository.FilmeListViewRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filme-list-view")
@AllArgsConstructor
public class FilmeListViewController {

  private final FilmeListViewRepository filmeListViewRepository;

  @GetMapping()
  public ResponseEntity<List<FilmesListView>> findAll(){
    return ResponseEntity.ok(filmeListViewRepository.findAll());
  }
}
