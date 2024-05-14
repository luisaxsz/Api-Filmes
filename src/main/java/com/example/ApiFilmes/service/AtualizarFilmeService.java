package com.example.ApiFilmes.service;
import org.modelmapper.ModelMapper;
import com.example.ApiFilmes.domain.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final ModelMapper mapper;

    public Filme update(Long id,Filme filmeAtualizado){
        var filme = filmeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
        filmeAtualizado.setId(id);
        mapper.map(filmeAtualizado, filme);
        return filmeRepository.save(filme);
    }
}
