package net.weg.automacao_ctw.Service;

import lombok.AllArgsConstructor;
import net.weg.automacao_ctw.Entity.Turma;
import net.weg.automacao_ctw.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TurmaService {

    private TurmaRepository repository;

    public List<Turma> salvarTurmas (List<Turma> alunos) {
        return repository.saveAll(alunos);
    }

    public Turma buscarTurma (String turma_nome) {
        return repository.findByNome(turma_nome);
    }
    
}
