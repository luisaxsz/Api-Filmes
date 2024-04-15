package com.example.ApiFilmes.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Data
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
