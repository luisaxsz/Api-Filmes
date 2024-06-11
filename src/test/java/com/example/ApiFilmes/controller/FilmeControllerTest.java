package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.model.Filme;
import com.example.ApiFilmes.repository.FilmeRepository;
import com.example.ApiFilmes.service.AtualizarFilmeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class FilmeControllerTest {

  @Autowired
  private MockMvc mvc;
  @MockBean
  private FilmeRepository filmeRepository;
  @MockBean
  private AtualizarFilmeService atualizarFilmeService;
  @Mock
  private Filme filme;
  @Mock
  private Filme filmeAtualizado;
  @Autowired
  private ObjectMapper jacksonObjectMapper;

  @Test
  void requisicaoPostParaFilmesDeveRetornar200() throws Exception {
    var json = """
        {
             "nome": "Velozes e Furiosos 9",
             "diretor": "Louis Leterrier",
             "duracao": "05:30:00" ,
             "genero" : {
                 "id": 1,
                 "nome": "Genero 1"
             }
         }
      """;
    var response = mvc.perform(post("/api/filme")
      .content(json).contentType(MediaType.APPLICATION_JSON))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoPostParaFilmesDeveRetornar400() throws Exception {

    var json = "";
    var response = mvc.perform(post("/api/filme")
      .content(json).contentType(MediaType.APPLICATION_JSON))
      .andReturn().getResponse();

    assertEquals(400, response.getStatus());
  }

  @Test
  void requisicaoFindById200() throws Exception {
    when(filmeRepository.findById(filme.getId())).thenReturn(Optional.of(filme));

    var response = mvc.perform(get("/api/filme/{id}", filme.getId()))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoFindById404() throws Exception {
    Integer id = 1;
    when(filmeRepository.findById(filme.getId())).thenReturn(Optional.empty());

    var response = mvc.perform(get("/api/filme/{id}", filme.getId()))
      .andReturn().getResponse();

    assertEquals("Id não encontrado!", response.getContentAsString());
    assertEquals(404, response.getStatus());
  }

  @Test
  void requisicaoDelete200() throws Exception {
    when(filmeRepository.existsById(filme.getId())).thenReturn(true);

    var response = mvc.perform(delete("/api/filme/{id}", filme.getId()))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoDelete404() throws Exception {
    when(filmeRepository.existsById(filme.getId())).thenReturn(false);

    var response = mvc.perform(delete("/api/filme/{id}", filme.getId()))
      .andReturn().getResponse();

    assertEquals(404, response.getStatus());
  }

  @Test
  void requisicaoPut200() throws Exception {
    when(filmeRepository.findById(filme.getId())).thenReturn(Optional.of(filme));
    when(atualizarFilmeService.exec(filme.getId(), filmeAtualizado)).thenReturn(filmeAtualizado);

    var response = mvc.perform(get("/api/filme/{id}", filme.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(jacksonObjectMapper.writeValueAsString(filmeAtualizado)))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoPut404() throws Exception {
    when(filmeRepository.findById(filme.getId())).thenReturn(Optional.empty());
    when(atualizarFilmeService.exec(filme.getId(), filme)).thenThrow(new EntityNotFoundException());

    var response = mvc.perform(get("/api/filme/{id}", filme.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(jacksonObjectMapper.writeValueAsString(filmeAtualizado)))
      .andReturn().getResponse();

    assertEquals("Id não encontrado!", response.getContentAsString());
    assertEquals(404, response.getStatus());
  }
}
