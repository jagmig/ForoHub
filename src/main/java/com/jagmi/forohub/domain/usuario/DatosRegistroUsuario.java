package com.jagmi.forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroUsuario(
        @NotBlank String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank String clave,
        @NotNull
        @Positive
        Long perfilId
) {
}
