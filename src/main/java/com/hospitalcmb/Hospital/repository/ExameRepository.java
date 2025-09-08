package com.hospitalcmb.Hospital.repository;

import com.hospitalcmb.Hospital.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

}
