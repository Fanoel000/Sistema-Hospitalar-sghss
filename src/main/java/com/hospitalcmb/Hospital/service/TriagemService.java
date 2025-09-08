package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.exception.ResourceNotFoundException;
import com.hospitalcmb.Hospital.model.Triagem;
import com.hospitalcmb.Hospital.repository.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TriagemService {

	 @Autowired
	    private TriagemRepository triagemRepository;

	    public List<Triagem> findAll() {
	        return triagemRepository.findAll();
	    }

	    public Optional<Triagem> findById(Long id) {
	        return triagemRepository.findById(id);
	    }

	    public Triagem save(Triagem triagem) {
	        return triagemRepository.save(triagem);
	    }

	    public Triagem update(Long id, Triagem triagemDetails) {
	        Triagem triagem = triagemRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Triagem não encontrada com ID: " + id));

	        triagem.setNome(triagemDetails.getNome());
	        triagem.setRg(triagemDetails.getRg());
	        triagem.setPressao(triagemDetails.getPressao());
	        triagem.setFebre(triagemDetails.getFebre());

	        return triagemRepository.save(triagem);
	    }

	    public void deleteById(Long id) {
	        if (!triagemRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Triagem não encontrada com ID: " + id);
	        }
	        triagemRepository.deleteById(id);
	    }
}
