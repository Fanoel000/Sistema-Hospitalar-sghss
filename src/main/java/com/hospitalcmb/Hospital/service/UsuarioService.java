package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.model.Usuario;
import com.hospitalcmb.Hospital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
}
