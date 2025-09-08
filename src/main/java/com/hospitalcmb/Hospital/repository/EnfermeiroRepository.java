package com.hospitalcmb.Hospital.repository;

import com.hospitalcmb.Hospital.model.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Long> {

}
