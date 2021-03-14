desafio-sessao-votacao-api :construction:
------------------------

API REST para gerenciar sessões de votação em pauta

Requisitos
------------------------

- Docker
- Java 1.8 +
- Maven

Funcionalidades
------------------------

- Cadastrar nova pauta
- Consultar pautas
- Abrir sessão de votação em pauta

Demonstração
------------------------

<https://desafio-sessao-votacao-api.herokuapp.com/swagger-ui/index.html>


Para construir a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-sessao-votacao-api
	$ mvn clean install -DskipTests

Para executar a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-sessao-votacao-api
	$ docker-compose -f src/main/docker/postgressql.yml up -d
	$ mvn spring-boot:run -Dspring-boot.run.profiles=dev

Documentação
------------------------

Swagger: <http://localhost:8080/swagger-ui/index.html>
