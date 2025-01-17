package com.jagmi.forohub.domain.topico.validaciones;

import com.jagmi.forohub.domain.ValidacionException;
import com.jagmi.forohub.domain.curso.Curso;
import com.jagmi.forohub.domain.curso.CursoRepository;
import com.jagmi.forohub.domain.topico.DatosCreacionTopico;
import com.jagmi.forohub.domain.topico.DatosMostrarTopico;
import com.jagmi.forohub.domain.topico.Topico;
import com.jagmi.forohub.domain.topico.TopicoRepository;
import com.jagmi.forohub.domain.usuario.Usuario;
import com.jagmi.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionCrearTopicoDuplicado {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosMostrarTopico registrar(DatosCreacionTopico datosCreacionTopico){
        boolean existeDuplicado = topicoRepository.existsByTitulo(datosCreacionTopico.titulo());
        if(existeDuplicado){
            throw new IllegalArgumentException("Ya existe un tópico con el mismo titulo");
        }

        Usuario autor = usuarioRepository.findById(datosCreacionTopico.idUsuario())
                .orElseThrow(() -> new ValidacionException("Autor No encontrado"));

        Curso curso = cursoRepository.findById(datosCreacionTopico.idCurso())
                .orElseThrow(() -> new ValidacionException("Curso no encontrado"));

        Topico topico = new Topico(datosCreacionTopico, autor, curso);
        topicoRepository.save(topico);

        return new DatosMostrarTopico(topico);
    }
}
