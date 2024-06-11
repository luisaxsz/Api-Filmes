package com.example.ApiFilmes.domain.vw;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("""
        select
            id,
            nome,
            diretor,
            duracao,
            genero
        from
            filmes_list_view
""")
public class FilmesListView {

  @Id
  private  Integer id;
  private  String nome;
  private  String diretor;
  private  String duracao;
  private  Long genero;
}
