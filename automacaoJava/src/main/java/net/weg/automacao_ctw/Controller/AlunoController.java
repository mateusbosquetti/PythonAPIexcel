package net.weg.automacao_ctw.Controller;

import lombok.AllArgsConstructor;
import net.weg.automacao_ctw.DTO.AlunoResquestDTO;
import net.weg.automacao_ctw.Entity.Aluno;
import net.weg.automacao_ctw.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService service;

    @PostMapping
    public ResponseEntity<List<Aluno>> postAlunos (@RequestBody List<AlunoResquestDTO> alunos) {
        try {
            return new ResponseEntity<>(service.salvarAlunos(alunos), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
