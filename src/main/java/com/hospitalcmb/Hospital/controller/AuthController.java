package com.hospitalcmb.Hospital.controller;


import com.hospitalcmb.Hospital.dto.JwtResponseDto;
import com.hospitalcmb.Hospital.dto.LoginDto;
import com.hospitalcmb.Hospital.dto.RegisterDto;
import com.hospitalcmb.Hospital.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Login e Registro de Usuários")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
		return authService.registerUser(registerDto);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody LoginDto loginDto) {
		return ResponseEntity.ok(authService.authenticateUser(loginDto));
	}

}
