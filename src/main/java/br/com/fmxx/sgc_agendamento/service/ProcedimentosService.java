package br.com.fmxx.sgc_agendamento.service;

import br.com.fmxx.sgc_agendamento.dto.ProcedimentosRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.ProcedimentosResponseDTO;
import br.com.fmxx.sgc_agendamento.entity.Procedimentos;
import br.com.fmxx.sgc_agendamento.exceptions.EntidadeInexistenteException;
import br.com.fmxx.sgc_agendamento.mapper.ProcedimentosMapper;
import br.com.fmxx.sgc_agendamento.repository.ProcedimentosRepository;
import br.com.fmxx.sgc_agendamento.validator.DadosInvalidosValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedimentosService {

    private final ProcedimentosRepository repository;
    private final ProcedimentosMapper mapper;

    public ProcedimentosResponseDTO criarProcedimentos(ProcedimentosRequestDTO procedimentosRequestDTO) throws IllegalAccessException {

        DadosInvalidosValidator.validar(procedimentosRequestDTO);

        Procedimentos novoProcedimento = repository.save(mapper.dtoToEntity(procedimentosRequestDTO));

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
