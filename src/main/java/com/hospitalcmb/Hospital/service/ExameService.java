package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.exception.ResourceNotFoundException;
import com.hospitalcmb.Hospital.model.Exame;
import com.hospitalcmb.Hospital.repository.EnfermeiroRepository;
import com.hospitalcmb.Hospital.repository.ExameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	public List<Exame> findAll() {
		return exameRepository.findAll();
	}

	public Optional<Exame> findById(Long id) {
		return exameRepository.findById(id);
	}

	public Exame save(Exame exame) {
		return exameRepository.save(exame);
	}

	public Exame update(Long id, Exame exameDetails) {
		Exame exame = exameRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado com ID: " + id));

		exame.setNome(exameDetails.getNome());
		exame.setIdade(exameDetails.getIdade());
		exame.setSexo(exameDetails.getSexo());
		exame.setEndereco(exameDetails.getEndereco());
		exame.setTelefone(exameDetails.getTelefone());
		exame.setMedicacao(exameDetails.getMedicacao());
		exame.setPrescricao(exameDetails.getPrescricao());
		exame.setDataRetorno(exameDetails.getDataRetorno());

		return exameRepository.save(exame);
	}

	public void deleteById(Long id) {
		if (!exameRepository.existsById(id)) {
			throw new ResourceNotFoundException("Exame não encontrado com ID: " + id);
		}
		exameRepository.deleteById(id);
	}

}
