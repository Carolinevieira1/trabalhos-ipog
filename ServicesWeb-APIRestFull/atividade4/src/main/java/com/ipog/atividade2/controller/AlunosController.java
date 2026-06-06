package com.ipog.atividade2.controller;

import com.ipog.atividade2.model.Alunos;
import com.ipog.atividade2.service.AlunosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/version-1/estudantes")
public class AlunosController {

    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public ResponseEntity<List<Alunos>> listar() {
        return ResponseEntity.ok(alunosService.puxarTodos());
    }

    @PostMapping
    public ResponseEntity<Alunos> incluir(@Valid @RequestBody Alunos estudante) {
        Alunos cadastrado = alunosService.gravar(estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> atualizar(@PathVariable Long id, @Valid @RequestBody Alunos dados) {
        Alunos modificado = alunosService.atualizarFicha(id, dados);
        return ResponseEntity.ok(modificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        alunosService.deletarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}