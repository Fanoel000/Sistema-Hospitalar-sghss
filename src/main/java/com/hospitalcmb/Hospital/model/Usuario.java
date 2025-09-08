package com.hospitalcmb.Hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String senha;

	    //@Column(nullable = false)
	    //private String profissao; // "Medico" ou "Enfermeiro"
	    
	    
//Codigo novo inicio
	    @Column
	    private String profissao; // ou cargo, role...

	    // getter e setter
	    public String getProfissao() {
	        return profissao;
	    }

	    public void setProfissao(String profissao) {
	        this.profissao = profissao;
	    }	    
//Codigo novo inicio
	
}
