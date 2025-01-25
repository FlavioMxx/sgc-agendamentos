package br.com.fmxx.sgc_agendamento.dto;

import br.com.fmxx.sgc_agendamento.validator.IgnorarDadosValidator;

public record EstabelecimentoDTO(
        @IgnorarDadosValidator
        Long id,
        String nomeEstabelecimento,
        String enderecoEstabelecimento,
        String contatoEstabelecimento,
        Boolean ativo
)
{ }