package com.jagmi.forohub.domain.topico;

import com.jagmi.forohub.domain.perfil.Perfil;
import com.jagmi.forohub.domain.usuario.Usuario;

public record DatosTopicoYUsuario(

        Long id,
        String nombre,
        String correoElectronico,
        Perfil perfil
) {
    public DatosTopicoYUsuario(Usuario datos){
        this(datos.getId(), datos.getNombre(), datos.getEmail(), datos.getPerfil());
    }
}

