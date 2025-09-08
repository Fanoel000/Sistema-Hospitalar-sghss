package com.hospitalcmb.Hospital.service;

import com.hospitalcmb.Hospital.dto.JwtResponseDto;
import com.hospitalcmb.Hospital.dto.LoginDto;
import com.hospitalcmb.Hospital.dto.RegisterDto;
import com.hospitalcmb.Hospital.model.Usuario;
import com.hospitalcmb.Hospital.repository.UsuarioRepository;
import com.hospitalcmb.Hospital.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtils jwtUtils;

	public ResponseEntity<?> registerUser(RegisterDto registerDto) {
		if (usuarioRepository.existsByEmail(registerDto.getEmail())) {
			return ResponseEntity.badRequest().body("Email já cadastrado!");
		}

		Usuario usuario = new Usuario();
		usuario.setEmail(registerDto.getEmail());
		usuario.setSenha(passwordEncoder.encode(registerDto.getSenha()));
		usuario.setProfissao(registerDto.getProfissao());

		usuarioRepository.save(usuario);
		return ResponseEntity.ok("Usuário registrado com sucesso!");
	}

	public JwtResponseDto authenticateUser(LoginDto loginDto) {
		Usuario usuario = usuarioRepository.findByEmail(loginDto.getEmail())
				.orElseThrow(() -> new RuntimeException("Email não encontrado!"));

		if (!passwordEncoder.matches(loginDto.getSenha(), usuario.getSenha())) {
			throw new RuntimeException("Senha incorreta!");
		}

		String token = jwtUtils.generateToken(usuario.getEmail());
		return new JwtResponseDto(token, usuario.getEmail(), usuario.getProfissao());
	}

}
