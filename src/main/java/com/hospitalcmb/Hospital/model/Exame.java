package com.hospitalcmb.Hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exames")
@Getter
@Setter
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Integer idade;
	private String sexo;
	private String endereco;
	private String telefone;
	private String medicacao;
	private String prescricao;
	private String dataRetorno; // Pode ser vazio

}
