package br.com.fmxx.sgc_agendamento.controller.advice;

import br.com.fmxx.sgc_agendamento.exceptions.DadosInvalidosException;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERRO_INESPERADO = "Erro inesperado: ";

    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<String> handleDadosInvalidosException(DadosInvalidosException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ERRO_INESPERADO + e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<String> handleEntidadeInexistenteException(EntityNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ERRO_INESPERADO + e.getMessage());
    }
}
