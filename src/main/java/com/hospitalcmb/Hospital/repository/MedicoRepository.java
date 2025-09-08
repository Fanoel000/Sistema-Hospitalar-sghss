package com.hospitalcmb.Hospital.repository;

import com.hospitalcmb.Hospital.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
