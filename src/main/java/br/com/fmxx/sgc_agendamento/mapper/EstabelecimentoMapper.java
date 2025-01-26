package br.com.fmxx.sgc_agendamento.mapper;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoResponseDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EstabelecimentoMapper {

    Estabelecimento requestDTOToEntity(EstabelecimentoRequestDTO dto);

    Estabelecimento responseDTOToEntity(EstabelecimentoResponseDTO dto);

    EstabelecimentoRequestDTO entityToRequestDTO(Estabelecimento entity);

    EstabelecimentoResponseDTO entityToResponseDTO(Estabelecimento entity);

    @Mapping(target = "id", ignore = true)
    void updateEstabelecimentoFromDTO(EstabelecimentoRequestDTO dto, @MappingTarget Estabelecimento estabelecimento);
}
