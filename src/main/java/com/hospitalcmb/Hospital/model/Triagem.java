package com.hospitalcmb.Hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "triagens")
@Getter
@Setter
public class Triagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String rg;
	private String pressao;
	private String febre;

}
