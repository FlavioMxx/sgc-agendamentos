package br.com.fmxx.sgc_agendamento.service;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoResponseDTO;
import br.com.fmxx.sgc_agendamento.dto.ProcedimentosRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.ProcedimentosResponseDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import br.com.fmxx.sgc_agendamento.entity.Procedimentos;
import br.com.fmxx.sgc_agendamento.exceptions.EntidadeInexistenteException;
import br.com.fmxx.sgc_agendamento.mapper.EstabelecimentoMapper;
import br.com.fmxx.sgc_agendamento.mapper.ProcedimentosMapper;
import br.com.fmxx.sgc_agendamento.repository.EstabelecimentoRepository;
import br.com.fmxx.sgc_agendamento.repository.ProcedimentosRepository;
import br.com.fmxx.sgc_agendamento.validator.DadosInvalidosValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//TODO: Converter todos os retornos para Procedimentos e fazer a conversao na CONTROLLER

@Service
@RequiredArgsConstructor
public class ProcedimentosService {

    private final ProcedimentosRepository repository;
    private final EstabelecimentoService estabelecimentoService;
    private final EstabelecimentoMapper estabelecimentoMapper;
    private final ProcedimentosMapper mapper;

    @Transactional
    public ProcedimentosResponseDTO criarProcedimentos(ProcedimentosRequestDTO procedimentosRequestDTO) throws IllegalAccessException {

        DadosInvalidosValidator.validar(procedimentosRequestDTO);

        Procedimentos novoProcedimento = mapper.dtoToEntity(procedimentosRequestDTO);

        EstabelecimentoResponseDTO estabelecimento = estabelecimentoService
                .buscarEstabelecimentoPorId(procedimentosRequestDTO.idEstabelecimento());

        novoProcedimento
                .setEstabelecimento(estabelecimentoMapper.responseDTOToEntity(estabelecimento));

        repository.save(novoProcedimento);

        return mapper
                .entityToResponseDTO(novoProcedimento);
    }

    public ProcedimentosResponseDTO atualizarProcedimentos(Long id, ProcedimentosRequestDTO procedimentosRequestDTO) throws IllegalAccessException {
        Procedimentos procedimento = repository.findById(id)
                .orElseThrow(() -> new EntidadeInexistenteException("Procedimentos nao existe: id" + id));

        DadosInvalidosValidator.validar(procedimentosRequestDTO);

        mapper.updateProcedimentoFromDTO(procedimentosRequestDTO, procedimento);

        repository.save(procedimento);

        return mapper
                .entityToResponseDTO(procedimento);
    }

    public List<ProcedimentosResponseDTO> buscarProcedimentos() {
        List<Procedimentos> procedimentosList = repository.findAll();

        if(procedimentosList.isEmpty())
            throw new EntidadeInexistenteException("Nao existem procedimentos/servicos cadastrados");

        return procedimentosList
                .stream()
                .map(mapper::entityToResponseDTO)
                .toList();
    }

    public String deletarProcedimentoPorID(Long id) {
        Procedimentos procedimento = repository.findById(id)
                .orElseThrow(() -> new EntidadeInexistenteException("Procedimentos nao existe: id" + id));

        repository.deleteById(id);

        return "Procedimento " + procedimento.getNomeProcedimento()
                + "\nid " + procedimento.getId()
                + "\nDELETADO COM SUCESSO!";
    }
}
