package br.com.camtwo.spring.controller;

import br.com.camtwo.spring.modal.Pessoa;
import br.com.camtwo.spring.modal.dto.PessoaDTO;
import br.com.camtwo.spring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> create(@Valid @RequestBody PessoaDTO dto) {

        Pessoa pessoa = pessoaService.save(dto.dtoToObject());
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long pessoaId) {
        Pessoa pessoa = pessoaService.findById(pessoaId);
        if (pessoa != null) return ResponseEntity.ok(pessoa);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> change(@Valid @PathVariable Long id, @RequestBody PessoaDTO dto) {
        if (!pessoaService.ifExists(id)) {
            return ResponseEntity.notFound().build();
        }
        dto.setId(id);
        return ResponseEntity.ok(pessoaService.save(dto.dtoToObject()));
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> delete(@PathVariable Long pessoaId) {
        if (!pessoaService.ifExists(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        pessoaService.deleteById(pessoaId);
        return ResponseEntity.noContent().build();
    }
}
