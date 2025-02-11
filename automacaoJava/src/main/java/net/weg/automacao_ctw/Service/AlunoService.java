package net.weg.automacao_ctw.Service;

import lombok.AllArgsConstructor;
import net.weg.automacao_ctw.DTO.AlunoResquestDTO;
import net.weg.automacao_ctw.Entity.Aluno;
import net.weg.automacao_ctw.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repository;
    private TurmaService turmaService;
    public List<Aluno> salvarAlunos (List<AlunoResquestDTO> alunosResquestDTO) {
        List<Aluno> alunos = new ArrayList<>();
        for (AlunoResquestDTO alunoResquestDTO : alunosResquestDTO) {
            alunos.add(DTOtoEntity(alunoResquestDTO));
        }
        return repository.saveAll(alunos);
    }

    private Aluno DTOtoEntity (AlunoResquestDTO alunoResquestDTO) {
        return new Aluno(alunoResquestDTO.getNome(), turmaService.buscarTurma(alunoResquestDTO.getTurma()));
    }

}
