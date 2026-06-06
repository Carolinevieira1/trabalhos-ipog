# Sistema de Controle de Matrículas e Alunos 

Oii professor. Este projeto consiste em um microsserviço focado no gerenciamento de uma escola. A aplicação foi estruturada seguindo as regras da arquitetura restfull com spring boot igual o senhor pediu no exercicio.

## Endpoints do Sistema

A URL de acesso base local foi mapeada para: `http://localhost:8080/api/matriculas`

* **Listagem Geral:** `GET /api/matriculas/listar`
* **Inclusão de Aluno:** `POST /api/matriculas/cadastrar`
* **Atualização Cadastral:** `PUT /api/matriculas/alterar/{id}`
* **Exclusão de Registro:** `DELETE /api/matriculas/remover/{id}`

---

## Estrutura de Resposta para Validações Complexas

Caso os dados enviados não siga as regras de negócio integradas na entidade, o sistema gera retornos que não vai causar erros gigantes e nem quebrar:

```json
{
  "momento": "2026-06-05T19:42:15",
  "codigoHttp": 400,
  "causa": "Inconsistência de Dados",
  "camposIncorretos": {
    "nome": "O nome inserido precisa ter entre 5 e 80 caracteres."
  }
}
```

Tive muita dificuldade na parte de criar a pasta expection, mas no final eu vi um vídeo de crud com validação de erros no youtube e com isso consegui finalizar e peguei uma ajuda pra corrigir uns erros que eu nãoconhecia