package br.com.fmxx.sgc_agendamento.dto;

import br.com.fmxx.sgc_agendamento.validator.IgnorarDadosValidator;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record EstabelecimentoRequestDTO(
        @Schema(defaultValue = "FMxx solucoes inteligentes")
        String nomeEstabelecimento,
        @Schema(defaultValue = "Rua avenida travessa, 123")
        String enderecoEstabelecimento,
        @Schema(defaultValue = "11987654321")
        String contatoEstabelecimento,
        @Schema(defaultValue = "true")
        Boolean ativo,
        @IgnorarDadosValidator
        List<ProcedimentosRequestDTO> procedimentos
)
{ }