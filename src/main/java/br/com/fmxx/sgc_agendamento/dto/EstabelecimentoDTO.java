package br.com.fmxx.sgc_agendamento.dto;

public record EstabelecimentoDTO(
        Long id,
        String nomeEstabelecimento,
        String enderecoEstabelecimento,
        String contatoEstabelecimento,
        Boolean ativo) {
}
