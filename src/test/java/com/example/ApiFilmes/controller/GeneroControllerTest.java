package com.example.ApiFilmes.controller;

import com.example.ApiFilmes.domain.model.Genero;
import com.example.ApiFilmes.repository.GeneroRepository;
import com.example.ApiFilmes.service.AtualizarGeneroService;
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
class GeneroControllerTest {

  @Autowired
  private MockMvc mvc;
  @MockBean
  private GeneroRepository generoRepository;
  @MockBean
  private AtualizarGeneroService atualizarGeneroService;
  @Mock
  private Genero genero;
  @Mock
  private Genero generoAtualizado;
  @Autowired
  private ObjectMapper jacksonObjectMapper;

  @Test
  void requisicaoPostParaGeneroDeveRetornar200() throws Exception {
    var json = """
        {
             "genero" : {
                 "id": 1,
                 "nome": "Genero 1"
             }
         }
      """;
    var response = mvc.perform(post("/api/genero")
        .content(json).contentType(MediaType.APPLICATION_JSON))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoPostParagenerosDeveRetornar400() throws Exception {
    var json = "";
    var response = mvc.perform(post("/api/genero")
        .content(json).contentType(MediaType.APPLICATION_JSON))
      .andReturn().getResponse();

    assertEquals(400, response.getStatus());
  }

  @Test
  void requisicaoFindById200() throws Exception {
    when(generoRepository.findById(genero.getId())).thenReturn(Optional.of(genero));

    var response = mvc.perform(get("/api/genero/{id}", genero.getId()))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoFindById404() throws Exception {
    Integer id = 1;
    when(generoRepository.findById(genero.getId())).thenReturn(Optional.empty());

    var response = mvc.perform(get("/api/genero/{id}", genero.getId()))
      .andReturn().getResponse();

    assertEquals("Id não encontrado!", response.getContentAsString());
    assertEquals(404, response.getStatus());
  }

  @Test
  void requisicaoDelete200() throws Exception {
    when(generoRepository.existsById(genero.getId())).thenReturn(true);

    var response = mvc.perform(delete("/api/genero/{id}", genero.getId()))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoDelete404() throws Exception {
    when(generoRepository.existsById(genero.getId())).thenReturn(false);

    var response = mvc.perform(delete("/api/genero/{id}", genero.getId()))
      .andReturn().getResponse();

    assertEquals(404, response.getStatus());
  }

  @Test
  void requisicaoPut200() throws Exception {
    when(generoRepository.findById(genero.getId())).thenReturn(Optional.of(genero));
    when(atualizarGeneroService.exec(genero.getId(), generoAtualizado)).thenReturn(generoAtualizado);

    var response = mvc.perform(get("/api/genero/{id}", genero.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(jacksonObjectMapper.writeValueAsString(generoAtualizado)))
      .andReturn().getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void requisicaoPut404() throws Exception {
    when(generoRepository.findById(genero.getId())).thenReturn(Optional.empty());
    when(atualizarGeneroService.exec(genero.getId(), genero)).thenThrow(new EntityNotFoundException());

    var response = mvc.perform(get("/api/genero/{id}", genero.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(jacksonObjectMapper.writeValueAsString(generoAtualizado)))
      .andReturn().getResponse();

    assertEquals("Id não encontrado!", response.getContentAsString());
    assertEquals(404, response.getStatus());
  }

}
