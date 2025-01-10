package br.com.fmxx.sgc_agendamento.exceptions;

public class DadosInvalidosException extends RuntimeException{

    public DadosInvalidosException(String menssagem) {
        super(menssagem);
    }
}
