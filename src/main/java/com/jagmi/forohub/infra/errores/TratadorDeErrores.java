package com.jagmi.forohub.infra.errores;

import com.jagmi.forohub.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tatarError404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tatarErrorDeValidacion(ValidacionException e){

        return ResponseEntity.badRequest().build();
    }

    private record DatosErrorValidacion(String campo, String error){

        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
