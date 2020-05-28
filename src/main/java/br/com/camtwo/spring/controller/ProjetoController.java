package br.com.camtwo.spring.controller;

import br.com.camtwo.spring.modal.Projeto;
import br.com.camtwo.spring.modal.dto.ProjetoDTO;
import br.com.camtwo.spring.service.PessoaService;
import br.com.camtwo.spring.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Projeto> findAll() {
        return projetoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Projeto> create(@Valid @RequestBody ProjetoDTO dto) {
        dto.setGerente(pessoaService.findById(dto.getGerente().getId()));
        Projeto pessoa = projetoService.save(dto.dtoToObjetc());
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id);
        if (projeto != null) return ResponseEntity.ok(projeto);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> change(@Valid @PathVariable Long id, @RequestBody ProjetoDTO dto) {
        if (!projetoService.ifExists(id)) {
            return ResponseEntity.notFound().build();
        }
        dto.setId(id);
        dto.setGerente(pessoaService.findById(dto.getGerente().getId()));
        return ResponseEntity.ok(projetoService.save(dto.dtoToObjetc()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!projetoService.ifExists(id)) {
            return ResponseEntity.notFound().build();
        }
        projetoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
