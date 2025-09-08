package com.hospitalcmb.Hospital.controller;

import com.hospitalcmb.Hospital.model.Triagem;
import com.hospitalcmb.Hospital.service.TriagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/triagens")
@Tag(name = "Triagens", description = "CRUD de Triagens")
public class TriagemController {

	@Autowired
    private TriagemService triagemService;

    @Operation(summary = "Listar todas as triagens")
    @GetMapping
    public ResponseEntity<List<Triagem>> getAll() {
        return ResponseEntity.ok(triagemService.findAll());
    }

    @Operation(summary = "Buscar triagem por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Triagem> getById(@PathVariable Long id) {
        return triagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar nova triagem")
    @PostMapping
    public ResponseEntity<Triagem> create(@RequestBody Triagem triagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(triagemService.save(triagem));
    }

    @Operation(summary = "Atualizar triagem")
    @PutMapping("/{id}")
    public ResponseEntity<Triagem> update(@PathVariable Long id, @RequestBody Triagem triagemDetails) {
        return ResponseEntity.ok(triagemService.update(id, triagemDetails));
    }

    @Operation(summary = "Deletar triagem")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        triagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }	
}
