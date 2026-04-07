# Aluno Online API

API REST em Java com Spring Boot para gerenciamento de `Aluno` e `Professor`, seguindo a arquitetura em camadas apresentada no material didático do site `aluno-online-uniesp-guia.vercel.app`.

O projeto implementa obrigatoriamente:

- CRUD completo de `Aluno`
- CRUD completo de `Professor`
- Persistência com PostgreSQL usando Spring Data JPA

## Objetivo do projeto

Este projeto foi construído para demonstrar um backend acadêmico simples, com foco nas entidades iniciais do domínio:

- `Aluno`
- `Professor`

A aplicação permite criar, listar, buscar por ID, atualizar e remover registros dessas entidades por meio de endpoints REST.

## Arquitetura utilizada

Foi utilizada a arquitetura em camadas, alinhada com o material de referência:

- `controller`: recebe as requisições HTTP e devolve as respostas
- `service`: concentra a regra de negócio e o tratamento de erros
- `repository`: faz o acesso ao banco com `JpaRepository`
- `model`: representa as entidades persistidas no banco de dados

Fluxo da aplicação:

`Client -> Controller -> Service -> Repository -> PostgreSQL`

## Estrutura do projeto

```text
src/main/java/br/com/alunoonline/api
├── controller
│   ├── AlunoController.java
│   └── ProfessorController.java
├── model
│   ├── Aluno.java
│   └── Professor.java
├── repository
│   ├── AlunoRepository.java
│   └── ProfessorRepository.java
├── service
│   ├── AlunoService.java
│   └── ProfessorService.java
└── ApiApplication.java
```

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## Configuração do banco

Arquivo: `src/main/resources/application.properties`

```properties
spring.application.name=Aluno Online API

spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online
spring.datasource.username=postgres
spring.datasource.password=123
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Antes de executar a aplicação, crie o banco `aluno_online` no PostgreSQL.

## Detalhamento do código

### Model

As classes `Aluno` e `Professor` representam tabelas do banco. Cada uma possui os campos:

- `id`
- `nome`
- `cpf`
- `email`

O `id` é gerado automaticamente com `GenerationType.IDENTITY`.

### Repository

Os repositórios `AlunoRepository` e `ProfessorRepository` estendem `JpaRepository`, o que fornece:

- `save`
- `findAll`
- `findById`
- `delete`

Sem necessidade de implementar SQL manualmente.

### Service

As classes de serviço:

- centralizam o CRUD
- buscam a entidade por ID
- lançam `404 Not Found` quando o registro não existe
- atualizam apenas os campos necessários antes de salvar

### Controller

Os controllers expõem os endpoints REST para cada entidade.

## Endpoints

### Aluno

- `POST /alunos`
- `GET /alunos`
- `GET /alunos/{id}`
- `PUT /alunos/{id}`
- `DELETE /alunos/{id}`

### Professor

- `POST /professores`
- `GET /professores`
- `GET /professores/{id}`
- `PUT /professores/{id}`
- `DELETE /professores/{id}`

## Exemplos de JSON

### Criar aluno

```json
{
  "nome": "Maria Silva",
  "cpf": "12345678900",
  "email": "maria@email.com"
}
```

### Criar professor

```json
{
  "nome": "Joao Santos",
  "cpf": "98765432100",
  "email": "joao@email.com"
}
```

## Como executar

1. Crie o banco `aluno_online` no PostgreSQL.
2. Ajuste usuário e senha no `application.properties`, se necessário.
3. Execute o projeto com:

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Prints do Insomnia

Substitua esta seção pelos prints reais das requisições.

![prints](C:\Users\lucas\Pictures\Screenshots\Captura de tela 2026-04-07 155658)

## Prints do DBeaver

### Tabelas

![print das tabelas](C:\Users\lucas\Pictures\Screenshots\Captura de tela 2026-04-07 155821)


## Observações finais

O código foi implementado com a mesma linha arquitetural do material de referência, mas adaptado para entregar o CRUD completo de `Aluno` e `Professor`, incluindo o `DELETE`, que não aparece completo em todas as partes do tutorial.
