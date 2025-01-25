package br.com.fmxx.sgc_agendamento.dto;

import br.com.fmxx.sgc_agendamento.validator.IgnorarDadosValidator;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProcedimentosRequestDTO(
        @Schema(defaultValue = "Criar botao personalizado em Angular")
        String nomeProcedimento,
        @Schema(defaultValue = "240")
        Integer duracaoMinutosProcedimento,
        @Schema(defaultValue = "350")
        BigDecimal valorProcedimento,
        @IgnorarDadosValidator
        @Schema(defaultValue = "Neste servico e oferecido a criacao e estilizacao de um componente botao para sua aplicacao.")
        String descricaoProcedimento
)
{ }
