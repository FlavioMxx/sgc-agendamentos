package br.com.fmxx.sgc_agendamento.validator;

import br.com.fmxx.sgc_agendamento.exceptions.DadosInvalidosException;

import java.lang.reflect.Field;

public class DadosEstabelecimentoValidator {

    public static void validar(Object objeto) throws IllegalAccessException {
        if (objeto == null) {
            throw new DadosInvalidosException("O objeto não pode ser nulo");
        }

        Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            campo.setAccessible(true);

            Object valor = campo.get(objeto);
            if (!campo.getName().equals("id")) {
                if (valor == null)
                    throw new DadosInvalidosException("O campo " + campo.getName() + " nao pode ser nulo.");
            }
        }
    }
}

