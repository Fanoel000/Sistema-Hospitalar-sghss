package com.hospitalcmb.Hospital.controller;

import com.hospitalcmb.Hospital.model.Medico;
import com.hospitalcmb.Hospital.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Tag(name = "Médicos", description = "CRUD de Médicos")
public class MedicoController {

	@Autowired
    private MedicoService medicoService;

    @Operation(summary = "Listar todos os médicos")
    @GetMapping
    public ResponseEntity<List<Medico>> getAll() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @Operation(summary = "Buscar médico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id) {
        return medicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar novo médico")
    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));
    }

    @Operation(summary = "Atualizar médico")
    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody Medico medicoDetails) {
        return ResponseEntity.ok(medicoService.update(id, medicoDetails));
    }

    @Operation(summary = "Deletar médico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
