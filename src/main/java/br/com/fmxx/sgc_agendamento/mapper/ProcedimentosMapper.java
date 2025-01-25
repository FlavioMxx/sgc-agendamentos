package br.com.fmxx.sgc_agendamento.mapper;

import br.com.fmxx.sgc_agendamento.dto.ProcedimentosRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.ProcedimentosResponseDTO;
import br.com.fmxx.sgc_agendamento.entity.Procedimentos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProcedimentosMapper {

    Procedimentos dtoToEntity(ProcedimentosRequestDTO dto);

    ProcedimentosRequestDTO entityToRequestDTO(Procedimentos entity);

    ProcedimentosResponseDTO entityToResponseDTO(Procedimentos entity);

    @Mapping(target = "id", ignore = true)
    void updateProcedimentoFromDTO(ProcedimentosRequestDTO dto, @MappingTarget Procedimentos procedimento);
}
