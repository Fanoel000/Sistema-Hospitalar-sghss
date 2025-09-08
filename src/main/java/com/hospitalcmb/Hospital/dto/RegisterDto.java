package com.hospitalcmb.Hospital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterDto {

	  @NotBlank
	    @Email
	    private String email;

	    @NotBlank
	    private String senha;

	    @NotBlank
	    private String profissao; // "Medico" ou "Enfermeiro"

	    // Getters e Setters
	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getSenha() { return senha; }
	    public void setSenha(String senha) { this.senha = senha; }

	    public String getProfissao() { return profissao; }
	    public void setProfissao(String profissao) { this.profissao = profissao; }
}
