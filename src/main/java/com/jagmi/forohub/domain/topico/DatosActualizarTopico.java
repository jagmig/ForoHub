package com.jagmi.forohub.domain.topico;

public record DatosActualizarTopico(

        String titulo,
        String mensaje,
        Estado estado,
        Long autor,
        Long curso
) {
}
