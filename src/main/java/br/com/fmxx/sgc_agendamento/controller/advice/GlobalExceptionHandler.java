package br.com.fmxx.sgc_agendamento.controller.advice;

import br.com.fmxx.sgc_agendamento.exceptions.DadosInvalidosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<String> handleDadosInvalidosxception(DadosInvalidosException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro inesperado: " + e.getMessage());
    }
}
