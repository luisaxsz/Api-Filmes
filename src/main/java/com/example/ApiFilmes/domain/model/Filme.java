package com.example.ApiFilmes.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String diretor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm:ss.SSSZ")
    private Time duracao;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
}
