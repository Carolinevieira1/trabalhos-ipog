package com.ipog.atividade2.service;

import com.ipog.atividade2.exception.EstudanteNaoEncontradoException;
import com.ipog.atividade2.model.Alunos;
import com.ipog.atividade2.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository repository;

    public List<Alunos> puxarTodos() {
        return repository.findAll();
    }

    public Alunos gravar(Alunos estudante) {
        return repository.save(estudante);
    }

    public Alunos atualizarFicha(Long id, Alunos novosDados) {
        if (!repository.existsById(id)) {
            throw new EstudanteNaoEncontradoException("Impossível atualizar. Registro acadêmico de ID " + id + " não localizado.");
        }
        novosDados.setId(id);
        return repository.save(novosDados);
    }

    public void deletarRegistro(Long id) {
        if (!repository.existsById(id)) {
            throw new EstudanteNaoEncontradoException("Falha ao remover. Estudante com o ID " + id + " não existe na base de dados.");
        }
        repository.deleteById(id);
    }
}