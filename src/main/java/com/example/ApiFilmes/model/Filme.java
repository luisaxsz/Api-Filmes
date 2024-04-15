package com.example.ApiFilmes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String diretor;
    private LocalDateTime duracao;
//    @ManyToOne(optional = false)
//    private Genero genero;
}
