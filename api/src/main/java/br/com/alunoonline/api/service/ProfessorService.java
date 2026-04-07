package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfessorService {

    @Autowired
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor criarProfessor(Professor professor) {
        professor.setId(null);
        return professorRepository.save(professor);
    }

    public List<Professor> listarTodosProfessores() {
        return professorRepository.findAll();
    }

    public Professor buscarProfessorPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor nao encontrado"));
    }

    public Professor atualizarProfessorPorId(Long id, Professor professor) {
        Professor professorPersistido = buscarProfessorPorId(id);
        professorPersistido.setNome(professor.getNome());
        professorPersistido.setCpf(professor.getCpf());
        professorPersistido.setEmail(professor.getEmail());
        return professorRepository.save(professorPersistido);
    }

    public void deletarProfessorPorId(Long id) {
        Professor professor = buscarProfessorPorId(id);
        professorRepository.delete(professor);
    }
}
