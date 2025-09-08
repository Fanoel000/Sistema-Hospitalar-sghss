package com.hospitalcmb.Hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enfermeiros")
@Getter
@Setter
public class Enfermeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ru;
	private String nome;
	private Integer idade;
	private String sexo;
	private String email;

}
