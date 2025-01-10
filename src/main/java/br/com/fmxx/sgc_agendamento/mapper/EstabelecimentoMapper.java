package br.com.fmxx.sgc_agendamento.mapper;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstabelecimentoMapper {

    Estabelecimento dtoToEntity(EstabelecimentoDTO dto);

    EstabelecimentoDTO entityToDto(Estabelecimento entity);
}
