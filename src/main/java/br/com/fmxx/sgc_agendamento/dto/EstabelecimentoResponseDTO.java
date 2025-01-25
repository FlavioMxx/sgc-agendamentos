package br.com.fmxx.sgc_agendamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EstabelecimentoResponseDTO(
        @Schema(defaultValue = "12324")
        Long id,
        @Schema(defaultValue = "FMxx solucoes inteligentes")
        String nomeEstabelecimento,
        @Schema(defaultValue = "Rua avenida travessa, 123")
        String enderecoEstabelecimento,
        @Schema(defaultValue = "11987654321")
        String contatoEstabelecimento,
        @Schema(defaultValue = "true")
        Boolean ativo
)
{ }
