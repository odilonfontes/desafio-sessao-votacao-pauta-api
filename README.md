Desafio Sessão Votação API (java 1.8 +)
------------------------

API REST para gerenciar sessões de votação em pauta

Requisitos
------------------------

- Docker
- Java 1.8 +
- Maven

Para construir a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-sessao-votacao-pauta-api
	$ mvn clean install

Para executar a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-sessao-votacao-pauta-api
	$ docker-compose -f src/main/docker/postgressql.yml up -d
	$ mvn spring-boot:run

Documentação da API REST
------------------------

Swagger: <http:localhost:8080/swagger-ui>
