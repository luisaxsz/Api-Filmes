package com.example.ApiFilmes.repository;

import com.example.ApiFilmes.domain.vw.FilmesListView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeListViewRepository extends JpaRepository<FilmesListView, Integer>{
}
