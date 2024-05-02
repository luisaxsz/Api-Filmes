CREATE OR REPLACE VIEW FILMES_LIST_VIEW
 SELECT
    F.ID,
    F.NOME,
    F.DIRETOR,
    F.DURACAO,
    G.NOME
 FROM FILMES F
 JOIN GENEROS G ON F.GENERO_ID = G.ID;