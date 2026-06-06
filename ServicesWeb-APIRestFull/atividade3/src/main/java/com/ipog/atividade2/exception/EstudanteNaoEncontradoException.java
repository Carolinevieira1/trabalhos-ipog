package com.ipog.atividade2.exception;

public class EstudanteNaoEncontradoException extends RuntimeException {
    public EstudanteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}