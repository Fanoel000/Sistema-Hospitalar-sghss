package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.exception.ResourceNotFoundException;
import com.hospitalcmb.Hospital.model.Paciente;
import com.hospitalcmb.Hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Copie e cole os mesmos padrões para: TriagemService.java, 
//EnfermeiroService.java, MedicoService.java, ExameService.java. 

@Service
public class PacienteService {
	
	@Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente update(Long id, Paciente pacienteDetails) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + id));

        paciente.setNome(pacienteDetails.getNome());
        paciente.setRg(pacienteDetails.getRg());
        paciente.setIdade(pacienteDetails.getIdade());
        paciente.setSexo(pacienteDetails.getSexo());
        paciente.setEndereco(pacienteDetails.getEndereco());
        paciente.setTelefone(pacienteDetails.getTelefone());

        return pacienteRepository.save(paciente);
    }

    public void deleteById(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }

}
