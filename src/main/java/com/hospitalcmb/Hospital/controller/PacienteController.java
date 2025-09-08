package com.hospitalcmb.Hospital.controller;

import com.hospitalcmb.Hospital.model.Paciente;
import com.hospitalcmb.Hospital.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Pacientes", description = "CRUD de Pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@Operation(summary = "Listar todos os pacientes")
	@GetMapping
	public ResponseEntity<List<Paciente>> getAll() {
		return ResponseEntity.ok(pacienteService.findAll());
	}

	@Operation(summary = "Buscar paciente por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getById(@PathVariable Long id) {
		return pacienteService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Criar novo paciente")
	@PostMapping
	public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
	}

	@Operation(summary = "Atualizar paciente")
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente paciente) {
		return ResponseEntity.ok(pacienteService.update(id, paciente));
	}

	@Operation(summary = "Deletar paciente")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pacienteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
