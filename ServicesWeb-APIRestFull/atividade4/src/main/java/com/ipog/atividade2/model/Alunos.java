package com.ipog.atividade2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, informe o nome completo do estudante.")
    @Size(min = 5, max = 80, message = "O nome inserido precisa ter entre 5 e 80 caracteres.")
    private String nome;

    @NotBlank(message = "A identificação da turma não pode ficar vazia.")
    @Size(max = 20, message = "O código da turma deve ter no máximo 20 caracteres.")
    private String turma;
}