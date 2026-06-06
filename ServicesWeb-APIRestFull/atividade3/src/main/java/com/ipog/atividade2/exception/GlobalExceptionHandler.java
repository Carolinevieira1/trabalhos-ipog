package com.ipog.atividade2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstudanteNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> tratarEstudanteOmissao(EstudanteNaoEncontradoException ex) {
        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("momento", LocalDateTime.now());
        corpo.put("codigoHttp", HttpStatus.NOT_FOUND.value());
        corpo.put("causa", "Registro Ausente");
        corpo.put("detalhes", ex.getMessage());

        return new ResponseEntity<>(corpo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarFalhaValidacao(MethodArgumentNotValidException ex) {
        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("momento", LocalDateTime.now());
        corpo.put("codigoHttp", HttpStatus.BAD_REQUEST.value());
        corpo.put("causa", "Inconsistência de Dados");

        Map<String, String> inconsistencias = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erro ->
                inconsistencias.put(erro.getField(), erro.getDefaultMessage())
        );
        corpo.put("camposIncorretos", inconsistencias);

        return new ResponseEntity<>(corpo, HttpStatus.BAD_REQUEST);
    }
}