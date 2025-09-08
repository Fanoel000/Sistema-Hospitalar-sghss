package com.hospitalcmb.Hospital.controller;


import com.hospitalcmb.Hospital.model.Enfermeiro;
import com.hospitalcmb.Hospital.service.EnfermeiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfermeiros")
@Tag(name = "Enfermeiros", description = "CRUD de Enfermeiros")
public class EnfermeiroController {
	
	 @Autowired
	    private EnfermeiroService enfermeiroService;

	    @Operation(summary = "Listar todos os enfermeiros")
	    @GetMapping
	    public ResponseEntity<List<Enfermeiro>> getAll() {
	        return ResponseEntity.ok(enfermeiroService.findAll());
	    }

	    @Operation(summary = "Buscar enfermeiro por ID")
	    @GetMapping("/{id}")
	    public ResponseEntity<Enfermeiro> getById(@PathVariable Long id) {
	        return enfermeiroService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @Operation(summary = "Criar novo enfermeiro")
	    @PostMapping
	    public ResponseEntity<Enfermeiro> create(@RequestBody Enfermeiro enfermeiro) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(enfermeiroService.save(enfermeiro));
	    }

	    @Operation(summary = "Atualizar enfermeiro")
	    @PutMapping("/{id}")
	    public ResponseEntity<Enfermeiro> update(@PathVariable Long id, @RequestBody Enfermeiro enfermeiroDetails) {
	        return ResponseEntity.ok(enfermeiroService.update(id, enfermeiroDetails));
	    }

	    @Operation(summary = "Deletar enfermeiro")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        enfermeiroService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
