package com.jagmi.forohub.domain.respuesta.validaciones;

import com.jagmi.forohub.domain.ValidacionException;
import com.jagmi.forohub.domain.respuesta.DatosCreacionRespuesta;
import com.jagmi.forohub.domain.respuesta.DatosMostarRespuesta;
import com.jagmi.forohub.domain.respuesta.Respuesta;
import com.jagmi.forohub.domain.respuesta.RespuestaRepository;
import com.jagmi.forohub.domain.topico.Topico;
import com.jagmi.forohub.domain.topico.TopicoRepository;
import com.jagmi.forohub.domain.usuario.Usuario;
import com.jagmi.forohub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidarPublicarRespuestaDuplicada {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosMostarRespuesta publicarRespuesta(DatosCreacionRespuesta creacionRespuesta){

        boolean existeRespuestaDuplicada = respuestaRepository.existsByMensaje(creacionRespuesta.mensaje());
        if(existeRespuestaDuplicada){
            throw new ValidacionException("Ya existe una respuesta con el mismo mensaje");
        }

        Topico topico = topicoRepository.findById(creacionRespuesta.idTopico())
                .orElseThrow(() -> new ValidacionException("No se encontró el topico con el id " + creacionRespuesta.idTopico()));

        Usuario usuario = usuarioRepository.findById(creacionRespuesta.idAutor())
                .orElseThrow(()-> new EntityNotFoundException("No se encontró el usuario"));

        Respuesta respuesta = new Respuesta(creacionRespuesta, topico, usuario);
        respuestaRepository.save(respuesta);

        return new DatosMostarRespuesta(respuesta);
    }

}
