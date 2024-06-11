package com.example.ApiFilmes.repository;

import com.example.ApiFilmes.domain.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
}
