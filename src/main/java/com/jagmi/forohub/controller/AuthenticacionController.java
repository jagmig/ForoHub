package com.jagmi.forohub.controller;

import com.jagmi.forohub.domain.usuario.DatosAutenticacionUsuario;
import com.jagmi.forohub.domain.usuario.Usuario;
import com.jagmi.forohub.infra.security.DatosJWTToken;
import com.jagmi.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAuticacionUsuario){

        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAuticacionUsuario.email(),
                datosAuticacionUsuario.clave());

        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JwtToken = tokenService.generateToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JwtToken));
    }


}
