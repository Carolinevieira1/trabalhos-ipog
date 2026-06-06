# Atividade 4 - API de Controle Escolar

Hii, professor! Esse é meu repositório da Atividade 4. Esta aplicação é um microsserviço voltado para a gestão de matrículas e registros de estudantes. O projeto foi todo construido para seguir um padrão de arquitetura em camadas bem pensada e conta com versionamento oficial e documentação automática.

---

## Organização e Arquitetura

Para cumprir o item 1 da atividade e não deixar o código virar uma bagunça, organizei as responsabilidades do sistema dividindo tudo em pastas específicas:
* `model`: Onde fica a nossa entidade `Alunos` com as anotações do JPA e regras de validação.
* `repository`: Interface que estende o JpaRepository para cuidar do banco.
* `service`: Aonde a mágica acontece! Toda a lógica de negócio e as tomadas de decisão foram isoladas aqui.
* `controller`: Só cuida da chegada e saída das requisições HTTP da API.
* `exception`: Nossa central global que intercepta erros e não deixa o sistema quebrar feio.

---

## Versionamento:

Seguindo as melhores práticas do mercado, adotei a estratégia de  URI. Todos os nossos endpoints agora começam com o prefixo `/version-1/`. E caso no futuro o sistema mudar, a gente não quebra os clientes antigos

* **Listar Estudantes:** `GET http://localhost:8080/api/version-1/estudantes`
* **Adicionar Cadastro:** `POST http://localhost:8080/api/version-1/estudantes`
* **Atualizar Ficha:** `PUT http://localhost:8080/api/version-1/estudantes/{id}`
* **Excluir Registro:** `DELETE http://localhost:8080/api/version-1/estudantes/{id}`

---

## Tratamento Avançado de Exceções & Validações (Item 3)

Usei o `@EstudanteNaoEncontradoExpection` da atividade passada para interceptar as falhas e gerar respostas customizadas em formato JSON super limpas.

### Exemplo de validação bloqueada
Se alguém tentar salvar um estudante enviando o campo `nome` em branco, a API barra na hora e retorna:
```json
{
  "timestamp": "2026-06-06T13:30:00",
  "status": 400,
  "error": "Requisição Inválida",
  "errors": {
    "nome": "O nome do estudante não pode ficar em branco."
  }
}