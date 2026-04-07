# Requisicoes Para Teste No Postman

Este arquivo contem exemplos de `body` e de chamadas HTTP para testar o CRUD completo de `Aluno` e `Professor`.

Base URL local:

```text
http://localhost:8080
```

Header para requisicoes com corpo:

```text
Content-Type: application/json
```

## Aluno

### Criar aluno

Metodo:

```text
POST /alunos
```

URL completa:

```text
http://localhost:8080/alunos
```

Body:

```json
{
  "nome": "Maria Silva",
  "cpf": "12345678900",
  "email": "maria.silva@email.com"
}
```

### Listar todos os alunos

Metodo:

```text
GET /alunos
```

URL completa:

```text
http://localhost:8080/alunos
```

Body:

```text
Nao possui body.
```

### Buscar aluno por id

Metodo:

```text
GET /alunos/{id}
```

Exemplo:

```text
http://localhost:8080/alunos/1
```

Body:

```text
Nao possui body.
```

### Atualizar aluno

Metodo:

```text
PUT /alunos/{id}
```

Exemplo:

```text
http://localhost:8080/alunos/1
```

Body:

```json
{
  "nome": "Maria Silva Atualizada",
  "cpf": "12345678900",
  "email": "maria.atualizada@email.com"
}
```

### Deletar aluno

Metodo:

```text
DELETE /alunos/{id}
```

Exemplo:

```text
http://localhost:8080/alunos/1
```

Body:

```text
Nao possui body.
```

## Professor

### Criar professor

Metodo:

```text
POST /professores
```

URL completa:

```text
http://localhost:8080/professores
```

Body:

```json
{
  "nome": "Joao Santos",
  "cpf": "98765432100",
  "email": "joao.santos@email.com"
}
```

### Listar todos os professores

Metodo:

```text
GET /professores
```

URL completa:

```text
http://localhost:8080/professores
```

Body:

```text
Nao possui body.
```

### Buscar professor por id

Metodo:

```text
GET /professores/{id}
```

Exemplo:

```text
http://localhost:8080/professores/1
```

Body:

```text
Nao possui body.
```

### Atualizar professor

Metodo:

```text
PUT /professores/{id}
```

Exemplo:

```text
http://localhost:8080/professores/1
```

Body:

```json
{
  "nome": "Joao Santos Atualizado",
  "cpf": "98765432100",
  "email": "joao.atualizado@email.com"
}
```

### Deletar professor

Metodo:

```text
DELETE /professores/{id}
```

Exemplo:

```text
http://localhost:8080/professores/1
```

Body:

```text
Nao possui body.
```

## Ordem sugerida para teste

1. Criar um aluno.
2. Listar alunos.
3. Buscar o aluno criado por ID.
4. Atualizar o aluno.
5. Deletar o aluno.
6. Repetir o mesmo fluxo para professor.

## Observacao

Se a aplicacao nao estiver rodando, inicie antes com:

```powershell
.\mvnw.cmd spring-boot:run
```
