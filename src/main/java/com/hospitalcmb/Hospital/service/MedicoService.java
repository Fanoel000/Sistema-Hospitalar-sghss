package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.exception.ResourceNotFoundException;
import com.hospitalcmb.Hospital.model.Medico;
import com.hospitalcmb.Hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}

	public Optional<Medico> findById(Long id) {
		return medicoRepository.findById(id);
	}

	public Medico save(Medico medico) {
		return medicoRepository.save(medico);
	}

	public Medico update(Long id, Medico medicoDetails) {
		Medico medico = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com ID: " + id));

		medico.setRu(medicoDetails.getRu());
		medico.setNome(medicoDetails.getNome());
		medico.setIdade(medicoDetails.getIdade());
		medico.setSexo(medicoDetails.getSexo());
		medico.setEmail(medicoDetails.getEmail());

		return medicoRepository.save(medico);
	}

	public void deleteById(Long id) {
		if (!medicoRepository.existsById(id)) {
			throw new ResourceNotFoundException("Médico não encontrado com ID: " + id);
		}
		medicoRepository.deleteById(id);
	}
}
