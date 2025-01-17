package com.jagmi.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCreacionCurso(

        @NotBlank
        String nombre,

        @NotNull
        Categoria categoria

) {
}
