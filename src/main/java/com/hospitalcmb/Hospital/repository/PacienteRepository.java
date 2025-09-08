package com.hospitalcmb.Hospital.repository;

// Faça o mesmo para: TriagemRepository.java, EnfermeiroRepository.java, MedicoRepository.java,
//ExameRepository.java.

import com.hospitalcmb.Hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	
	
}
