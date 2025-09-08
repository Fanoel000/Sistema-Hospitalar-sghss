package com.hospitalcmb.Hospital.repository;

import com.hospitalcmb.Hospital.model.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriagemRepository extends JpaRepository<Triagem, Long> {

}
