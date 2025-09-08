package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.exception.ResourceNotFoundException;
import com.hospitalcmb.Hospital.model.Enfermeiro;
import com.hospitalcmb.Hospital.repository.EnfermeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermeiroService {

	@Autowired
	private EnfermeiroRepository enfermeiroRepository;

	public List<Enfermeiro> findAll() {
		return enfermeiroRepository.findAll();
	}

	public Optional<Enfermeiro> findById(Long id) {
		return enfermeiroRepository.findById(id);
	}

	public Enfermeiro save(Enfermeiro enfermeiro) {
		return enfermeiroRepository.save(enfermeiro);
	}

	public Enfermeiro update(Long id, Enfermeiro enfermeiroDetails) {
		Enfermeiro enfermeiro = enfermeiroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Enfermeiro não encontrado com ID: " + id));

		enfermeiro.setRu(enfermeiroDetails.getRu());
		enfermeiro.setNome(enfermeiroDetails.getNome());
		enfermeiro.setIdade(enfermeiroDetails.getIdade());
		enfermeiro.setSexo(enfermeiroDetails.getSexo());
		enfermeiro.setEmail(enfermeiroDetails.getEmail());

		return enfermeiroRepository.save(enfermeiro);
	}

	public void deleteById(Long id) {
		if (!enfermeiroRepository.existsById(id)) {
			throw new ResourceNotFoundException("Enfermeiro não encontrado com ID: " + id);
		}
		enfermeiroRepository.deleteById(id);
	}

}
