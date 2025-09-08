package com.hospitalcmb.Hospital.config;

import com.hospitalcmb.Hospital.security.JwtUtils;
import com.hospitalcmb.Hospital.service.UsuarioService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getToken(request);

        if (token != null) {
            try {
                if (jwtUtils.validateToken(token)) {
                    String email = jwtUtils.getEmailFromToken(token);
                    var usuarioOpt = usuarioService.findByEmail(email); // 👈 Alterado: nome da variável para deixar claro que é Optional

                    if (usuarioOpt.isPresent()) { // 👈 Alterado: verificamos se o Optional contém valor
                        var usuario = usuarioOpt.get(); // 👈 Alterado: extraímos o valor do Optional

                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        usuario,
                                        null,
                                        Collections.singletonList(
                                                new org.springframework.security.core.authority.SimpleGrantedAuthority(
                                                        "ROLE_" + usuario.getProfissao().trim().toUpperCase()
                                                )
                                        )
                                );
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (ExpiredJwtException e) {
                request.setAttribute("jwtExpired", Boolean.TRUE);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}