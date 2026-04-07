package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlunoService {

    @Autowired
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno criarAluno(Aluno aluno) {
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }

    public Aluno atualizarAlunoPorId(Long id, Aluno aluno) {
        Aluno alunoPersistido = buscarAlunoPorId(id);
        alunoPersistido.setNome(aluno.getNome());
        alunoPersistido.setCpf(aluno.getCpf());
        alunoPersistido.setEmail(aluno.getEmail());
        return alunoRepository.save(alunoPersistido);
    }

    public void deletarAlunoPorId(Long id) {
        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }
}
