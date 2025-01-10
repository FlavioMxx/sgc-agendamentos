package br.com.fmxx.sgc_agendamento.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class EntidadeInexistenteException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public EntidadeInexistenteException(String mensagem) {
        super(mensagem);
    }
}
