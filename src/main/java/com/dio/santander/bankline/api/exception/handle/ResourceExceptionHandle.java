package com.dio.santander.bankline.api.exception.handle;

import com.dio.santander.bankline.api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandle {
    @ExceptionHandler(CorrentistaNotFound.class)
    public ResponseEntity<DetalhesErro> InternaalException(CorrentistaNotFound ex) {

        DetalhesErro erro = new DetalhesErro.DetalhesErroBuild()
                .titulo("Not Found")
                .timestamp(System.currentTimeMillis())
                .status(404L)
                .menssagemDesenvolvedor(ex.getMessage())
                .create();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }
    @ExceptionHandler(CorrentistaNotSave.class)
    public ResponseEntity<DetalhesErro> InternaalException(CorrentistaNotSave ex) {

        DetalhesErro erro = new DetalhesErro.DetalhesErroBuild()
                .titulo("Not Create")
                .timestamp(System.currentTimeMillis())
                .status(409L)
                .menssagemDesenvolvedor(ex.getMessage())
                .create();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

    }
    @ExceptionHandler(CorrentistaNotBalance.class)
    public ResponseEntity<DetalhesErro> InternaalException(CorrentistaNotBalance ex) {

        DetalhesErro erro = new DetalhesErro.DetalhesErroBuild()
                .titulo("Bad Request")
                .timestamp(System.currentTimeMillis())
                .status(400L)
                .menssagemDesenvolvedor(ex.getMessage())
                .create();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

    }
    @ExceptionHandler(MovimentacaoNotSave.class)
    public ResponseEntity<DetalhesErro> InternaalException(MovimentacaoNotSave ex) {

        DetalhesErro erro = new DetalhesErro.DetalhesErroBuild()
                .titulo("Not Save")
                .timestamp(System.currentTimeMillis())
                .status(409L)
                .menssagemDesenvolvedor(ex.getMessage())
                .create();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

    }
}
