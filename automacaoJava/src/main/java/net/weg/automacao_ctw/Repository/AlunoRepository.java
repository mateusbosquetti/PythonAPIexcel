package net.weg.automacao_ctw.Repository;

import net.weg.automacao_ctw.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
