package com.example.ApiFilmes.repository;

import com.example.ApiFilmes.domain.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {
}
