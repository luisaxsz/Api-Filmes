# SpringBoot

- Para executar o projeto, é necessário ter o Java 17, Maven e Docker instalados.
- Essa é uma api básica e simples apenas para utilizar e testar e aprofundar conhecimentos em docker, kubernets e ci/cd com github actions. A api ainda tá passando por alterações alterações. 

## Inicialize banco de dados

Para inicializar o banco de dados execute o comando `docker compose up` na pasta raiz do projeto.

- Certifique-se de que a porta 3306 esteja disponível. Caso contrário, altere a porta no arquivo `docker-compose.yml` e `application.properties` ou pare o seu serviço do mySql.

## Inicialize o projeto

Para inicializar o projeto, execute o comando `mvn spring-boot:run` na pasta raiz do projeto.

- Certifique-se que container do banco de dados esteja rodando antes de rodar aplicação.

# Webapp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.0.0.

## Install dependencies

Execute `npm install` para instalar todas as dependências do projeto.

## Development server

Execute `ng serve` para rodar projeto. Navegue até o `http://localhost:4200/` para visualizar projeto. O aplicativo será recarregado automaticamente se você alterar qualquer um dos arquivos de origem.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
