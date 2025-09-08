package com.hospitalcmb.Hospital.controller;

import com.hospitalcmb.Hospital.model.Exame;
import com.hospitalcmb.Hospital.service.ExameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exames")
@Tag(name = "Exames", description = "CRUD de Exames (Prescrições Médicas)")
public class ExameController {

	 @Autowired
	    private ExameService exameService;

	    @Operation(summary = "Listar todos os exames")
	    @GetMapping
	    public ResponseEntity<List<Exame>> getAll() {
	        return ResponseEntity.ok(exameService.findAll());
	    }

	    @Operation(summary = "Buscar exame por ID")
	    @GetMapping("/{id}")
	    public ResponseEntity<Exame> getById(@PathVariable Long id) {
	        return exameService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @Operation(summary = "Criar novo exame")
	    @PostMapping
	    public ResponseEntity<Exame> create(@RequestBody Exame exame) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(exameService.save(exame));
	    }

	    @Operation(summary = "Atualizar exame")
	    @PutMapping("/{id}")
	    public ResponseEntity<Exame> update(@PathVariable Long id, @RequestBody Exame exameDetails) {
	        return ResponseEntity.ok(exameService.update(id, exameDetails));
	    }

	    @Operation(summary = "Deletar exame")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        exameService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
