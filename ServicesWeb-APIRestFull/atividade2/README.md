# API de Gerenciamento de Alunos

Esta é uma API RESTful desenvolvida com Spring Boot para a atividade de APIRESTfull, onde demonstrando a implementação prática dos métodos HTTP (CRUD).

## Usei:
* Java 17 / 21
* Spring Boot
* Spring Data JPA
* Banco de Dados H2 (Em memória)

## Endpoints:

A URL base da aplicação local é: `http://localhost:8080/atividade/restfull`

---

### Listar todos os Alunos
* **Método:** `GET`
* **URL:** `/atividade/restfull`
* **Código de Resposta Esperado:** `200 OK`

### Cadastrar dados de um Aluno
* **Método:** `POST`
* **URL:** `/atividade/restfull`
* **Código de Resposta Esperado:** `200`
* **Corpo (JSON):**
  ```json
  {
    "nome": "Joãozinho",
    "turma": "7º - B"
  }


### Deletar registro de Alunos
* **Método:** `DELETE`
* **URL:** `/atividade/restfull/{id}`
* **Código de Resposta Esperado:** `200 OK`

### Atualizar dados de um Aluno
* **Método:** `PUT`
* **URL:** `/atividade/restfull/{id}`
* **Código de Resposta Esperado:** `200`
* **Corpo (JSON):**
  ```json
  {
    "nome": "Joãozinho",
    "turma": "7º - A"
  }