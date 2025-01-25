package br.com.fmxx.sgc_agendamento.service;

import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoRequestDTO;
import br.com.fmxx.sgc_agendamento.dto.EstabelecimentoResponseDTO;
import br.com.fmxx.sgc_agendamento.entity.Estabelecimento;
import br.com.fmxx.sgc_agendamento.exceptions.EntidadeInexistenteException;
import br.com.fmxx.sgc_agendamento.mapper.EstabelecimentoMapper;
import br.com.fmxx.sgc_agendamento.repository.EstabelecimentoRepository;
import br.com.fmxx.sgc_agendamento.validator.DadosInvalidosValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository repository;
    private final EstabelecimentoMapper mapper;

    public EstabelecimentoResponseDTO criarEstabelecimento(EstabelecimentoRequestDTO estabelecimentoRequestDTO) throws IllegalAccessException {

        DadosInvalidosValidator.validar(estabelecimentoRequestDTO);

        Estabelecimento novoEstabelecimento = repository.save(mapper.dtoToEntity(estabelecimentoRequestDTO));

        return mapper.entityToResponseDTO(novoEstabelecimento);
    }

    public EstabelecimentoResponseDTO atualizarEstabelecimento(Long id, EstabelecimentoRequestDTO estabelecimentoRequestDTO) throws IllegalAccessException {
        Estabelecimento estabelecimento = repository.findById(id)
                .orElseThrow(() -> new EntidadeInexistenteException("Estabelecimento nao existe: id" + id));

        DadosInvalidosValidator.validar(estabelecimentoRequestDTO);

        mapper.updateEstabelecimentoFromDTO(estabelecimentoRequestDTO, estabelecimento);

        repository.save(estabelecimento);

        return mapper
                .entityToResponseDTO(estabelecimento);
    }

    public List<EstabelecimentoResponseDTO> buscarEstabelecimentos() {
        List<Estabelecimento> estabelecimentoList = repository.findAll();

        if(estabelecimentoList.isEmpty())
            throw new EntidadeInexistenteException("Nao existem estabelecimentos cadastrados");

        return estabelecimentoList
                .stream()
                .map(mapper::entityToResponseDTO)
                .toList();
    }

    public String deletarEstabelecimentoPorID(Long id) {
    	
    	Estabelecimento estabelecimento = repository.findById(id)
                .orElseThrow(() -> new EntidadeInexistenteException("Estabelecimento nao existe: id" + id));

        repository.deleteById(id);

		return "Estabelecimento " + estabelecimento.getNomeEstabelecimento()
                + "\nid " + estabelecimento.getId()
                + "\nDELETADO COM SUCESSO!";
    }
}
