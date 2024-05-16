package com.example.ApiFilmes.service;

import com.example.ApiFilmes.domain.model.Genero;
import com.example.ApiFilmes.repository.GeneroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarGeneroService {
  private final GeneroRepository generoRepository;
  private final ModelMapper mapper;

  public Genero update(Long id, Genero generoAtualizado){
    var genero = generoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
    generoAtualizado.setId(id);
    mapper.map(generoAtualizado, genero);
    return generoRepository.save(genero);
  }
}
