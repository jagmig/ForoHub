package com.jagmi.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCreacionRespuesta(

        @NotBlank
        String mensaje,
        @NotNull
        Long idTopico,
        @NotNull
        Long idAutor
) {
}
