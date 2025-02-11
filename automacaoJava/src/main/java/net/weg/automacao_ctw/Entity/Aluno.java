package net.weg.automacao_ctw.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nome;

    @ManyToOne
    @NonNull
    private Turma turma;

}
