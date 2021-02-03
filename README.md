Desafio Sessão Votação API :
------------------------

API REST para gerenciar sessões de votação em pauta

Requisitos
------------------------

- Docker
- Java 1.8 +
- Maven

Funcionalidades
------------------------

- Cadastrar uma nova pauta

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

Documentação
------------------------

Swagger: <http:localhost:8080/swagger-ui>
