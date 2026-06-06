package com.ipog.atividade2.controller;

import com.ipog.atividade2.exception.EstudanteNaoEncontradoException;
import com.ipog.atividade2.model.Alunos;
import com.ipog.atividade2.repository.AlunosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Alunos>> listarTodos() {
        List<Alunos> lista = alunosRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Alunos> cadastrar(@Valid @RequestBody Alunos novoAluno) {
        Alunos alunoSalvo = alunosRepository.save(novoAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Alunos> atualizar(@PathVariable Long id, @Valid @RequestBody Alunos dadosNovos) {
        Alunos alunoModificado = alunosRepository.findById(id)
                .map(registroAntigo -> {
                    registroAntigo.setNome(dadosNovos.getNome());
                    registroAntigo.setTurma(dadosNovos.getTurma());
                    return alunosRepository.save(registroAntigo);
                })
                .orElseThrow(() -> new EstudanteNaoEncontradoException("Nenhum estudante localizado com o código de identificação: " + id));

        return ResponseEntity.status(HttpStatus.OK).body(alunoModificado);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!alunosRepository.existsById(id)) {
            throw new EstudanteNaoEncontradoException("Impossível efetuar a exclusão. Registro #" + id + " não existe.");
        }
        alunosRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}