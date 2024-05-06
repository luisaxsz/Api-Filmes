package com.example.ApiFilmes.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String diretor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm:ss.SSSZ")
    private Time duracao;
    @ManyToOne(optional = false)
    @JoinColumn(name = "genero_id")
    private Genero genero;
}
