package com.example.ApiFilmes.service;
import org.modelmapper.ModelMapper;
import com.example.ApiFilmes.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final ModelMapper mapper;

    public Filme findById(Long id){
        var filme = filmeRepository.findById(id);
        return filme.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
    }

    public Filme update(Long id,Filme filmeAtualizado){
        var filme = filmeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
        filmeAtualizado.setId(id);
        mapper.map(filmeAtualizado, filme);
        return filmeRepository.save(filme);
    }
}
