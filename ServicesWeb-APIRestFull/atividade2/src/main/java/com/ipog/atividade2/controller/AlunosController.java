package com.ipog.atividade2.controller;


import com.ipog.atividade2.model.Alunos;
import com.ipog.atividade2.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividade/restfull")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping
    public List<Alunos> findAll() {
        return alunosRepository.findAll();
    }

    @PostMapping
    public Alunos save(@RequestBody Alunos alunos) {
        return alunosRepository.save(alunos);
    }

    @PutMapping("/{id}")
    public Alunos Update(@PathVariable Long id, @RequestBody Alunos alunoNovo) {
        return alunosRepository.findById(id).map(alunoCadastrado -> {
            alunoCadastrado.setNome(alunoNovo.getNome());
            alunoCadastrado.setTurma(alunoNovo.getTurma());
            return alunosRepository.save(alunoCadastrado);
        }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunosRepository.deleteById(id);
    }
}
