package net.weg.automacao_ctw.Controller;

import lombok.AllArgsConstructor;
import net.weg.automacao_ctw.Entity.Turma;
import net.weg.automacao_ctw.Service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turma")
@AllArgsConstructor
public class TurmaController {

    private TurmaService service;

    @PostMapping
    public ResponseEntity<List<Turma>> postTurmas (@RequestBody List<Turma> turmas) {
        try {
            return new ResponseEntity<>(service.salvarTurmas(turmas), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
    
}
