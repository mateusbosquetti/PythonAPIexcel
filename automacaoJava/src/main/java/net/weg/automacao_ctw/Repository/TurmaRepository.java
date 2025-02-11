package net.weg.automacao_ctw.Repository;

import net.weg.automacao_ctw.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    public Turma findByNome(String nome);
}
